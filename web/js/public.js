function setQueryString() {
    var param = "";
    for (var i = 0; i < arguments.length; i++) {
        param += arguments[i] + '=' + arguments[i + 1];
        if (i !== arguments.length - 2) {
            param += "&";
            i++;
        } else {
            break;
        }

    }
    return param;
}

function Seach() {
    document.form1.seachstr = undefined;
    if (document.form1.seachstr.value == "") {
        alert('ÇëÌîÐ´²éÑ¯¹Ø¼ü×Ö');
        return false;
    } else {
        document.form1.submit();
    }
}

function BooksPage(page, seach, bookTypeID, seachstr) {
    window.navigate('BooksPageAction.do?' + setQueryString('page', page, 'seach', seach, 'bookTypeID', bookTypeID, 'seachstr', seachstr));
}

function printTime(time) {
    document.write(time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8));
}
