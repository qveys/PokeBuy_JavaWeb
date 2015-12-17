$(document).ready(function () {
    var $menu_navigation = $('#main-nav'),
            $cart_trigger = $('#panier-logo'),
            $lateral_cart = $('#cd-cart'),
            $shadow_layer = $('#cd-shadow-layer');

    //open cart
    $cart_trigger.on('click', function (event) {
        event.preventDefault();
        toggle_panel_visibility($lateral_cart, $shadow_layer, $('body'));
    });

    //close lateral cart
    $shadow_layer.on('click', function () {
        $shadow_layer.removeClass('is-visible');
        // firefox transitions break when parent overflow is changed, so we need to wait for the end of the trasition to give the body an overflow hidden
        if ($lateral_cart.hasClass('speed-in')) {
            $lateral_cart.removeClass('speed-in').on('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $('body').removeClass('overflow-hidden');
            });
            $menu_navigation.removeClass('speed-in');
        } else {
            $menu_navigation.removeClass('speed-in').on('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $('body').removeClass('overflow-hidden');
            });
            $lateral_cart.removeClass('speed-in');
        }
    });

    //open popup
    $('.checkout-btn').on('click', function (event) {
        event.preventDefault();
        $('#cd-shadow-layer').removeClass("is-visible");
        $('#cd-cart').removeClass("speed-in");
        $('.cd-popup').addClass('is-visible');
    });

    //close popup
    $('.cd-popup').on('click', function (event) {
        if ($(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup')) {
            event.preventDefault();
            $(this).removeClass('is-visible');
        }
    });

});


function toggle_panel_visibility($lateral_panel, $background_layer, $body) {
    if ($lateral_panel.hasClass('speed-in')) {
        // firefox transitions break when parent overflow is changed, so we need to wait for the end of the trasition to give the body an overflow hidden
        $lateral_panel.removeClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $body.removeClass('overflow-hidden');
        });
        $background_layer.removeClass('is-visible');

    } else {
        $lateral_panel.addClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $body.addClass('overflow-hidden');
        });
        $background_layer.addClass('is-visible');
    }
}