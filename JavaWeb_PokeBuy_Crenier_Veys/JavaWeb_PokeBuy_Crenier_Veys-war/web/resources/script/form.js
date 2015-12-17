(function () {

var hasClass, addClass, removeClass;

  hasClass = function( elem, c ) {
    return elem.classList.contains( c );
  };
  addClass = function( elem, c ) {
    elem.classList.add( c );
  };
  removeClass = function( elem, c ) {
    elem.classList.remove( c );
  };

    [].slice.call(document.querySelectorAll('input.input_field')).forEach(function (inputEl) {
        // in case the input is already filled..
        if (inputEl.value.trim() !== '') {
            addClass(inputEl.parentNode, 'input-filled');
        } else {
            removeClass(inputEl.parentNode, 'input-filled');
        }
        // events:
        inputEl.addEventListener('focus', onInputFocus);
        inputEl.addEventListener('blur', onInputBlur);
    });

    function onInputFocus(ev) {
        addClass(ev.target.parentNode, 'input-filled');
    }

    function onInputBlur(ev) {
        if (ev.target.value.trim() === '') {
            removeClass(ev.target.parentNode, 'input-filled');
        }
    }
    
})();