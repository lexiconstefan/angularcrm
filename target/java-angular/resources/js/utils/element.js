/**
 * 
 */
var Elem = Base.extend({
	constructor : function() {
	},
	element : null,
	createElement : function(args) {

		if (args.element) {
			switch (args.element) {
			case 'input':
				return this.createInput(args);
			case 'img':
				return this.createImg(args);
			case 'div':
				return this.createDiv(args);
			case 'select':
				return this.createSelect(args);
			case 'label':
				return this.createLabel(args);
			case 'span':
				return this.createSpan(args);
			default:
				break;
			}
		}
	},
	createTable : function(args){
		this.element = document.createElement('table');
		for(var i = 0;i<args.tr.length;i++){
			var tr = document.createElement('tr');
			for(var i =0;i<args.td.length;i++){
				
			}
		}
	},
	createSpan : function(args) {
		this.element = document.createElement('span');
		this.element.className = args.className || '';
		this.element.innerHTML = args.text || '';
		this.element.id = args.id || ''
		
		return this.element;
	},
	createInput : function(args) {
		this.element = document.createElement('input');
		this.element.type = args.type || 'text'
		this.element.className = args.className || '';
		this.element.name = args.name || '';
		this.element.readOnly = args.readOnly || false;
		this.element.value = args.value || ''

		return this.element;
	},
	createLabel : function(args) {
		this.element = document.createElement('label');
		this.element.innerHTML = args.text;
		return this.element;
	},
	createDiv : function(args) {
		this.element = document.createElement('div');
		this.element.className = args.className || '';
		this.element.id = args.id || '';
		if (args.style) {
			this.addStyleToElement(args.style);
		}
		return this.element;
	},
	createImg : function(args) {
		this.element = document.createElement('img');
		this.element.src = args.src || '';
		this.element.className = args.className || ''
		if (args.style) {
			this.addStyleToElement(args.style);
		}
		return this.element;
	},
	createSelect : function(args) {
		this.element = document.createElement('select');
		if (args.options) {
			var arrOptions = args.options;
			for (var i = 0; i < arrOptions.length; i++) {
				var option = document.createElement('option');
				option.text = arrOptions[i];
				if (args.value && args.value[i]) {
					option.value = args.value[i];
				} else {
					option.value = arrOptions[i]
				}
				this.element.appendChild(option);
			}
		}
		this.element.className = args.className;
		return this.element;
	},
	addStyleToElement : function(style) {
		var styles = style.split(';');
		for (var i = 0; i < styles.length; i++) {
			var s = styles[i].split(':');
			this.element.style[s[0]] = s[1];
		}
	},
	getElement : function() {
		return this.element;
	},
	appendByTagName : function(tagName) {
		var tagNameArray = document.getElementByTagNames(tagName);
		tagNameArray.forEach(function(tagParent) {
			tagParent.appendChild(this.element);
		});

	},
	appendByID : function(id) {
		document.getElemntById(id).appendChild(this.element);

	},
	addClasses : function() {
		this.element.className = this.classes.length === 1 ? this.classes[0]
				: this.classes.forEach(function(className) {
					this.element.className += className + ' ';
				});

	},

});