/**
 * Exibe um conteudo de um objeto
 * @param o
 */
function printObject(o) {
	var out = '';
	for (var p in o) {
		out += p + ': ' + o[p] + '\n';
	}
	alert(out);
}

function redirect(url){
	window.location = url;
}

function letraDoNumero(num){
	alfabeto = [];
	letras = range('A', 'Z');
	$.each(letras, function(index, item) {
		alfabeto[index] = item;
	});
	return alfabeto[num-1];
}

/**
 * Valida data
 * @param pObj
 * @returns {Boolean}
 */
function isDate(txtDate) {
	
    var currVal = txtDate;
    if (currVal == '' || currVal == undefined)
        return false;
    
    //Declare Regex 
    var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var dtArray = currVal.match(rxDatePattern); // is format OK?

    if (dtArray == null)
        return false;

    //Checks for mm/dd/yyyy format.
    dtMonth = dtArray[1];
    dtDay = dtArray[3];
    dtYear = dtArray[5];

    if (dtMonth < 1 || dtMonth > 12) {
        return false;
    } else if (dtDay < 1 || dtDay > 31) {
        return false;
    } else if ((dtMonth == 4 || dtMonth == 6 || dtMonth == 9 || dtMonth == 11) && dtDay == 31) {
        return false;
    } else if (dtMonth == 2) {
        var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
        if (dtDay > 29 || (dtDay == 29 && !isleap)) {
            return false;
        }
    }
    return true;
}