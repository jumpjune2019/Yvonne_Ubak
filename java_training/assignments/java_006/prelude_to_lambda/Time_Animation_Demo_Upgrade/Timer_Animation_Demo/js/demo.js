/**
 * @param {string} title -	JavaScript Demo (DMJS)
 * @param {string} author - Claude Gauthier
 * @param {string} email -	claude_r_gauthier@hotmail.com
 * @param {string} date -	2013-12-10
 * 
 */
((window) => {
	var	document = window.document,
		core_version = "0.1",
		isReady = false,
		launchFn,
		calcXY = (anchor, obj, container) => {
			var getEnd = (cont, obj) =>{
				return cont - obj;
			};
			var objW = obj.clientWidth,
				objH = obj.clientHeight,
				contW = container.clientWidth,
				contH = container.clientHeight,
				x, y;
				
			switch(anchor) {
				case "tl":
					x = 0;
					y = 0;
				break;
				
				case "br":
				default:
					x = getEnd(contW, objW);
					y = getEnd(contH, objH);
				break;								
			}
			return {
				x: x,
				y: y
			}
		},
		calcAnimPath = (start, end) => {
			// based on Bresenham's line drawing algorithm
			var x0 = start.x, y0 = start.y,
				x1 = end.x, y1 = end.y,
				path = [], coord = {},
				dy = y1 - y0, dx = x1 - x0,
				d = 2 * dy - dx,
				x = x0, y = y0;
				
			while(x <= x1) {
				coord.x = x;
				coord.y = y;
				path.push($.cloneObject(coord));
				x++;
				if(d < 0) {
					d += dy + dy;
				} else {
					d += 2 * (dy - dx);
					y++;
				}
			}

			return path;
		},
		DMJS = {
			// info
			getVersion: () => {
				return core_version;
			},
			// ready
			ready: (fn) => {
				launchFn = fn;
			},
			getReadyState: () => {
				return isReady;				
			},
			// get will be set using NormalizeAPI()
			get: null,
			getBody: () => {
				return document.getElementsByTagName('body')[0];
			},
			// addEvent and removeEvent will be set using normalizeAPI()
			addEvent: null,
			removeEvent: null,
			// various object inspection functions
			getConstructorName: (obj)=> {
				if(obj == undefined || obj == null) {
					return null;
				}
				if(obj.constructor) {
					if(obj.constructor.name) {
						return obj.constructor.name.toLowerCase();
					} else {
						var temp = obj.constructor.toString().toLowerCase(),
							st = temp.indexOf('function ') + 9,
							en = temp.indexOf('(');
						return temp.substr(st, en - st);
					}
				}
			},
			isEmptyObject: (obj) =>{
				for(var key in obj) {
					return false;
				}
				return true;
			},			
			isObjectType: (obj, type) => {
				var val = false;
				if(obj == undefined || obj == null) {
					return val;
				}				
				if($.getConstructorName(obj) == type) {
					val = true;
				}
				return val;				
			},	
			// object type inspection		
			isArray: (obj) =>{
				return $.isObjectType(obj, "array");
			},
			isString: (obj) => {
				return $.isObjectType(obj, "string");
			},	
			isObject: (obj) => {
				return $.isObjectType(obj, "object");
			},			
			// clone Object
			//loses functionality with arrow function - constructor
			cloneObject: function(obj) {
				if(obj == null || $.isObject(obj) == false) {
					return obj;
				}
				var returnObj = obj.constructor();
				for(key in obj) {
					returnObj[key] = this.cloneObject(obj[key]);
				}
				return returnObj;
			},
			// animation function returning an animation object with an interface		
			setAnimation: (obj) =>{
				if($.isEmptyObject(obj) || !obj.target || !obj.start || !obj.end) {
					return null;
				}
				var target = obj.target,
					container = $.getBody(),
					container = obj.container ? obj.container : container,
					start = obj.start,
					end = obj.end,
					startPos,
					endPos,
					path = [];
					
				if($.isArray(start)) {
					startPos = {
						x: start[0],
						y: start[1]
					};
				} else {
					if($.isString(start)) {
						startPos = calcXY(start, target, container);
					}
				}
				
				if($.isArray(end)) {
					endPos = {
						x: end[0],
						y: end[1]
					};
				} else {
					if($.isString(end)) {
						endPos = calcXY(end, target, container);
					}
				}				
				path = calcAnimPath(startPos, endPos);
				return (
					(animObj, animPath) => {

						var target = animObj,
							path = animPath,
							index = 0,
							timer,
							l = animPath.length,
							dir = l;
						
						var setPixelVal = (coord) => {
							return coord + "px"
						};
						
						var setCoord = (path) => {
							target.style.left = setPixelVal(path.x);
							target.style.top = setPixelVal(path.y);
						};

						var show = () => {
							target.style.visibility = "visible";	
						};
						
						var anim = (index)=> {
							setCoord(path[index]);
						};
						
						return {
							//loses functionality with arrow function - this
							start: function() {
								anim(index);
								show();
								this.resume();
							},
							resume: () => {
								timer = setInterval(() => {
									if(index >= dir - 1) {
										dir = 0;
									}
									if(index <= 0) {
										dir = l;
									}
									if(dir == l) {
 										index = index + 1;
									} 
									if(dir == 0) {
										index = index - 1;
									}
									anim(index);
								}, 1); 
							},	
							pause: ()=> {
								clearInterval(timer);
							}
						}
					}
				)(target, path)				
			},
			string: {
				//loses functionality with arrow function - arguements operator
				format: function() {
					var l = arguments.length,
						str;
					if(l < 2) {
						return null;
					}
					str = arguments[0];
					for(x = l-1; x >= 1; x--) {
						str = str.replace(new RegExp('\\{' + (x - 1) + '\\}', 'gm'), arguments[x]);
					}
					return str;
				}
			}
		},
		initDMJS = () => {
			$.isReady = true;
			launchFn.call(DMJS);
		},
		/** in order to deal with cross browser issues
			i'm using feature detection in order to 
			assign proper functionality to the methods */
		normalizeAPI = () => {
			// set GET method
			// todo - normalize the element obj
			var getFn,
				addEventFn,
				removeEventFn;
				
			// giving precedence to document.all for Windows CE IE browsers
			if(document.getElementById) {
				getFn = (id) => {
					return document.getElementById(id);
				}
			
			} else {
				if(document.all) {
					getFn = (id) => {
						return document.all[id];
					}
				}				
			}
			DMJS.get = getFn;
			if(document.addEventListener) {
				addEventFn = (el, type, fn) => {
					el.addEventListener(type, fn, false);
					return fn;
				}
				
				removeEventFn = (el, type, fn) => {
					el.removeEventListener(type, fn, false);
				}
				
			} else {
				if(document.attachEvent) {
					addEventFn =  (el, type, fn) => {
						var temp = () => {
							return fn.apply(el, arguments);
						}
						el.attachEvent("on" + type, temp);
						return temp;
					}
					
					removeEventFn = (el, type, fn) => {
						el.detachEvent("on" + type, fn);
					}
				}
			}
			DMJS.addEvent = addEventFn;
			DMJS.removeEvent = removeEventFn;
		};
	
	normalizeAPI();
	
	if ( typeof window === "object" && typeof window.document === "object" ) {
		window.DMJS = window.$ = DMJS;
	}
	
	window.onload = initDMJS;
	
})(window);