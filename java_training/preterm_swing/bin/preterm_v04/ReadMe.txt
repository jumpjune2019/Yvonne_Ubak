This is the fourth iteration of this Movie Booking System.

The Swing application is setup
	*create frame
	*create panel with BorderLayout
		- title (NORTH)
		-JList of clients and seating matrix(CENTER)
			~Client list in panel with FlowLayout
			~seating matrix is a panel with a gridlayout
		-reset entire matrix button
		- print seating assignments button

This iteration will have add some functionality to the swing application
	*select client
	*click book button
		- write id: 01/YU (id/initials)
		- add new Room object
		-remove client from JList
		-change button text to Unbook
	* click unbook button
		- add client back to JList
		- change label to vacant
		- change button text to book
	*click reset entire matrix button
		- reload JList
		- reload matrix
	*click print seating button
		- print client list and seat assignment in console
		