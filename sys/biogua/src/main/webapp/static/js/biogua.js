/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Modal Confirmación ELIMINACIÓN*/
/**
 * Función que valida la cofirmación de la eliminación de un registro
 * @param {type} url al que va a direccionar luego de la confirmacion 
 * @param {type} descripcion (Se ha eliminado+ descripcion)
 * @returns {undefined}
 * @autor acrajovi
 */
function confirmarEliminacion(url, descripcion) {
    $.confirm({
        theme: 'Modern',
        type: 'red',
        animation: 'RotateX',
        closeAnimation: 'scaleY',
        typeAnimated: true,
        icon: 'fa fa-trash fa-xs',
        columnClass: 'col-lg-6',
        escapeKey: 'Cancelar',
        title: '¿Desea eliminar <b> \'' + descripcion + '\'?',
        content: 'Esta acción se <b>\'cancelará\'</b> automáticamente en <b>5</b> segundos si usted no <b>\'confirma \'</b> la acción.',
        autoClose: 'Cancelar|5000',

        buttons: {
            Confirmar: {
                text: 'Confirmar',
                btnClass: 'btn-danger',

                action: function () {
                    window.location.href = url;
                    $.dialog({
                        title: 'Información!',
                        content: 'Se ha <b>eliminado</b> ' + descripcion
                    });
                }
            },
            Cancelar: function () {
                btn: 'btn-red',
//                        $.alert('Acción <b>cancelada</b>.');
                        $.alert({
                            title: 'Información!',
                            content: 'Acción <b>cancelada</b>.!'
                        });
            }
        }
    });
}
;

/*Modal Confirmación ELIMINACIÓN*/
/**
 * Función que valida la cofirmación de la eliminación de un registro
 * @param {type} url al que va a direccionar luego de la confirmacion 
 * @param {type} descripcion (Se ha eliminado+ descripcion)
 * @returns {undefined}
 * @autor acrajovi
 */
function confirmarReicioPass(url, descripcion) {
    $.confirm({
        theme: 'Modern',
        type: 'red',
        animation: 'RotateX',
        closeAnimation: 'scaleY',
        typeAnimated: true,
        icon: 'fa fa-unlock fa-xs',
        columnClass: 'col-lg-6',
        escapeKey: 'Cancelar',
        title: '¿Desea restablecer la contraseña genérica del sistema para el usuario <b> \'' + descripcion + '\'?',
        content: 'Esta acción se <b>\'cancelará\'</b> automáticamente en <b>5</b> segundos si usted no <b>\'confirma \'</b> la acción.',
        autoClose: 'Cancelar|5000',

        buttons: {
            Confirmar: {
                text: 'Confirmar',
                btnClass: 'btn-danger',

                action: function () {
                    window.location.href = url;

                    $.dialog({
                        title: 'Información!',
                        content: 'Se ha <b>reinciado la contraseña</b> ' + descripcion
                    });
                }
            },
            Cancelar: function () {
                btn: 'btn-red',
//                        $.alert('Acción <b>cancelada</b>.');
                        $.alert({
                            title: 'Información!',
                            content: 'Acción <b>cancelada</b>.!'
                        });
            }
        }
    });
}
;

/*menu*/

function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("btnMenuOpen").style.display = "none";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("btnMenuOpen").style.display = "block";
}

/* accordion menu plugin*/
;
(function ($, window, document, undefined) {
    var pluginName = "accordion";
    var defaults = {
        speed: 200,
        showDelay: 0,
        hideDelay: 0,
        singleOpen: true,
        clickEffect: true,
        indicator: 'submenu-indicator-minus',
        subMenu: 'submenu',
        event: 'click touchstart' // click, touchstart
    };

    function Plugin(element, options) {
        this.element = element;
        this.settings = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }
    $.extend(Plugin.prototype, {
        init: function () {
            this.openSubmenu();
            this.submenuIndicators();
            if (defaults.clickEffect) {
                this.addClickEffect();
            }
        },
        openSubmenu: function () {
            $(this.element).children("ul").find("li").bind(defaults.event, function (e) {
                e.stopPropagation();
                e.preventDefault();
                var $subMenus = $(this).children("." + defaults.subMenu);
                var $allSubMenus = $(this).find("." + defaults.subMenu);
                if ($subMenus.length > 0) {
                    if ($subMenus.css("display") == "none") {
                        $subMenus.slideDown(defaults.speed).siblings("a").addClass(defaults.indicator);
                        if (defaults.singleOpen) {
                            $(this).siblings().find("." + defaults.subMenu).slideUp(defaults.speed)
                                    .end().find("a").removeClass(defaults.indicator);
                        }
                        return false;
                    } else {
                        $(this).find("." + defaults.subMenu).delay(defaults.hideDelay).slideUp(defaults.speed);
                    }
                    if ($allSubMenus.siblings("a").hasClass(defaults.indicator)) {
                        $allSubMenus.siblings("a").removeClass(defaults.indicator);
                    }
                }
                window.location.href = $(this).children("a").attr("href");
            });
        },
        submenuIndicators: function () {
            if ($(this.element).find("." + defaults.subMenu).length > 0) {
                $(this.element).find("." + defaults.subMenu).siblings("a").append("<span class='submenu-indicator'>+</span>");
            }
        },
        addClickEffect: function () {
            var ink, d, x, y;
            $(this.element).find("a").bind("click touchstart", function (e) {
                $(".ink").remove();
                if ($(this).children(".ink").length === 0) {
                    $(this).prepend("<span class='ink'></span>");
                }
                ink = $(this).find(".ink");
                ink.removeClass("animate-ink");
                if (!ink.height() && !ink.width()) {
                    d = Math.max($(this).outerWidth(), $(this).outerHeight());
                    ink.css({
                        height: d,
                        width: d
                    });
                }
                x = e.pageX - $(this).offset().left - ink.width() / 2;
                y = e.pageY - $(this).offset().top - ink.height() / 2;
                ink.css({
                    top: y + 'px',
                    left: x + 'px'
                }).addClass("animate-ink");
            });
        }
    });
    $.fn[pluginName] = function (options) {
        this.each(function () {
            if (!$.data(this, "plugin_" + pluginName)) {
                $.data(this, "plugin_" + pluginName, new Plugin(this, options));
            }
        });
        return this;
    };
})(jQuery, window, document);


var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-36251023-1']);
_gaq.push(['_setDomainName', 'jqueryscript.net']);
_gaq.push(['_trackPageview']);
jQuery(document).ready(function ($) {
    $("#menu").accordion();
    $(".colors a").click(function () {
        if ($(this).attr("class") != "default") {
            $("#menu").removeClass();
            $("#menu").addClass("menu").addClass($(this).attr("class"));
        } else {
            $("#menu").removeClass();
            $("#menu").addClass("menu");
        }
    });
});



/*FUNCIONES UPPER LOWER*/
(function ($) {
    $.fn.extend({

        // With every keystroke capitalize first letter of ALL words in the text
        upperFirstAll: function () {
            $(this).keyup(function (event) {
                var box = event.target;
                var txt = $(this).val();
                var start = box.selectionStart;
                var end = box.selectionEnd;

                $(this).val(txt.toLowerCase().replace(/^(.)|(\s|\-)(.)/g,
                        function (c) {
                            return c.toUpperCase();
                        }));
                box.setSelectionRange(start, end);
            });
            return this;
        },

        // With every keystroke capitalize first letter of the FIRST word in the text
        upperFirst: function () {
            $(this).keyup(function (event) {
                var box = event.target;
                var txt = $(this).val();
                var start = box.selectionStart;
                var end = box.selectionEnd;

                $(this).val(txt.toLowerCase().replace(/^(.)/g,
                        function (c) {
                            return c.toUpperCase();
                        }));
                box.setSelectionRange(start, end);
            });
            return this;
        },

        // Converts with every keystroke the hole text to lowercase
        lowerCase: function () {
            $(this).keyup(function (event) {
                var box = event.target;
                var txt = $(this).val();
                var start = box.selectionStart;
                var end = box.selectionEnd;

                $(this).val(txt.toLowerCase());
                box.setSelectionRange(start, end);
            });
            return this;
        },

        // Converts with every keystroke the hole text to uppercase
        upperCase: function () {
            $(this).keyup(function (event) {
                var box = event.target;
                var txt = $(this).val();
                var start = box.selectionStart;
                var end = box.selectionEnd;

                $(this).val(txt.toUpperCase());
                box.setSelectionRange(start, end);
            });
            return this;
        },

        noFormatText: function () {
            $(this).keyup(function (event) {
                var box = event.target;
                var txt = $(this).val();
                var start = box.selectionStart;
                var end = box.selectionEnd;

                $(this).val(txt.toUp);
                box.setSelectionRange(start, end);
            });
            return this;
        }

    });
}(jQuery));



/**
 * Funciones que se ejecutan en los formularios
 * + Para que funcione el tooltip
 * + Para poner mayúscula primera letra
 * @returns {undefined}
 */
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip()
    $('input[type=text]').upperFirstAll();
    $('#usuario').lowerCase();
    $('#faIcon').lowerCase();
//    $('#link').noFormatText();
});

/**
 * Función jquery-confirm utilizada para msotrar mensajes de alerta de tiempo de inactividad máxima del usuario alcanzada
 * @returns {undefined}
 */
function sessionTimeOut() {
    var urlLogout = '/biogua/logout';
    var urlMenu = '/biogua/menuPrincipal';
    $.confirm({
        theme: 'Modern',
        type: 'red',
        animation: 'RotateX',
        closeAnimation: 'scaleY',
        typeAnimated: true,
        icon: 'fa fa-user-times fa-xs',
        columnClass: 'col-lg-6',
        escapeKey: 'Cancelar',
        title: 'Tiempo de inanctividad máxima alcanzada.',
        content: 'Por seguridad usted será <b>redirigido</b> al menú pricipal o a la pantalla de login automáticamente en <b>10</b> segundos.',
        autoClose: 'Salir|10000',
        buttons: {
            Salir: {
                text: 'Cerrar sesión',
                btnClass: 'btn-danger',
                action: function () {
                    window.location.href = urlLogout;
                }
            },
            Permanecer: {
                text: 'Menú Principal',
                btn: 'btn-red',
                action: function () {
                    window.location.href = urlMenu;
                }
            }}
    });
}
;

$(document).ready(function () {

    /*********************************************** boton hacia arriba **********************************************/
    $('.ir-arriba').click(function () {
        $('body, html').animate({
            scrollTop: '0px'
        }, 500);
    });

    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            $('.ir-arriba').slideDown(600);
        } else {
            $('.ir-arriba').slideUp(600);
        }
    });

    /*hacia abajo*/
    $('.ir-abajo').click(function () {
        $('body, html').animate({
            scrollTop: '1000px'
        }, 500);
    });

});
