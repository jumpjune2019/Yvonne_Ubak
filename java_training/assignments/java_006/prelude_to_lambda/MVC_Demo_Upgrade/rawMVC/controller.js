var Controller = (function() {

	//loses functionality when written as a lambda function
	var addButtonClickEvent = function(textTrigger, event) {
		var model = this;
		var value = textTrigger.value.trim();
		if(value.length) {
			if(model.notDuplicate(value)) {
				model.Add(value);
				textTrigger.value = null;
			} else {
				alert("Duplicate Value");
			}
		};
	
	};

	//loses functionality when written as a lambda function
	var deleteButtonClickEvent = function(event) {
		var model = this;
		if(event.target.type == "button") {
			model.Delete(event.target.value);
		
		}
	
	}

	//loses functionality when written as a lambda function
	var constructor = function() {

		var scopeEl;
		var model;
		var view;

		this.init = (el, m, v) => {
			scopeEl = el;
			model = m;
			view = v;
			model.setScope(el);
			model.setView(view);
			model.registerWidget(view.listView());
			model.registerWidget(view.summaryView());
			model.refreshWidgets(view, model);
			
			
			var addButton = view.triggerField().getButtonInstance(el);
			var textTrigger = view.triggerField().getTextInstance(el);
			
			addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));
			
			var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
			listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));
			
		};
		
	};
	
	return new constructor();
	
});