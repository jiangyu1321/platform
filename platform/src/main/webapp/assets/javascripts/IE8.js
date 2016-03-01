/* IE8 */
if (typeof console == "undefined")
  window.console = window.console || (function() {
    var c = {};
    c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function() {};
    return c;
  })();
(function(g) {


  Date.prototype.Format = function(fmt) { //author: meizz   
    var o = {
      "M+": this.getMonth() + 1, //æä»½   
      "d+": this.getDate(), //æ¥   
      "h+": this.getHours(), //å°æ¶   
      "m+": this.getMinutes(), //å   
      "s+": this.getSeconds(), //ç§   
      "q+": Math.floor((this.getMonth() + 3) / 3), //å­£åº¦   
      "S": this.getMilliseconds() //æ¯«ç§   
    };
    fmt = fmt || "yyyy-MM-dd hh:mm:ss"
    if (/(y+)/.test(fmt))
      fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
      if (new RegExp("(" + k + ")").test(fmt))
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
  }



  var _date = Date.prototype.constructor;

  function uDate(str) {
    if (!str)
      return new _date();
    var date = new _date(str);
    if (isNaN(date) && typeof str == "string") {
      date = new _date(0);
      var param = str.split(" ");
      var pa = param[0] && param[0].match(/\d{1,}/g) || [];
      var pb = param[1] && param[1].match(/\d{1,}/g) || [];
      if (pa && pa.length) {
        var year = pa[0] || "1900";
        var mounth = parseInt(pa[1] || 1);
        var day = pa[2] || "1";
        date.setDate(day);
        date.setMonth(mounth - 1);
        date.setYear(year);
      }
      if (pb && pb.length) {
        var hour = pb[0] || "0";
        var min = pb[1] || "0";
        var sec = pb[2] || "0";
        date.setHours(hour);
        date.setMinutes(min);
        date.setSeconds(sec);
        date.setMilliseconds(0)
      }
    }
    return date;
  }

  g.Date = function(p) {
    return new uDate(p);
  }

  g.uDate = uDate;

  // 判断IE版本
  msie = parseInt((/msie (\d+)/.exec(navigator.userAgent.toLowerCase()) || [])[1]);
  if (isNaN(msie)) {
    msie = parseInt((/trident\/.*; rv:(\d+)/.exec(navigator.userAgent.toLowerCase()) || [])[1]);
  }

  if (msie < 8)
    console.info("不支援IE7及以下浏览器，当前UA" + navigator.userAgent); // 

  if (msie == 8) {
    console.info("当前浏览器为IE8，启动兼容程序块");
    // Object.create
    // src https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/create

    if (typeof Object.create != 'function') {
      Object.create = (function() {
        function Temp() {}
        var hasOwn = Object.prototype.hasOwnProperty;
        return function(O) {
          if (typeof O != 'object') {
            throw TypeError('Object prototype may only be an Object or null');
          }
          Temp.prototype = O;
          var obj = new Temp();
          Temp.prototype = null;
          if (arguments.length > 1) {
            var Properties = Object(arguments[1]);
            for (var prop in Properties) {
              if (hasOwn.call(Properties, prop)) {
                obj[prop] = Properties[prop];
              }
            }
          }
          return obj;
        };
      })();
    }

    // FUN.bind
    // src http://www.jb51.net/article/56363.htm
    if (!Function.prototype.bind) {
      Function.prototype.bind = function(oThis) {
        if (typeof this !== "function") {
          throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
        }
        var aArgs = Array.prototype.slice.call(arguments, 1),
          fToBind = this,
          fNOP = function() {},
          fBound = function() {
            return fToBind.apply(this instanceof fNOP && oThis ? this : oThis,
              aArgs.concat(Array.prototype.slice.call(arguments)));
          };
        fNOP.prototype = this.prototype;
        fBound.prototype = new fNOP();
        return fBound;
      };
    }

    // Array.indexOf
    // src https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Array/indexOf
    if (!Array.prototype.indexOf) {
      Array.prototype.indexOf = function(searchElement, fromIndex) {
        var k;
        if (this == null) {
          throw new TypeError('"this" is null or not defined');
        }
        var O = Object(this);
        var len = O.length >>> 0;
        if (len === 0) {
          return -1;
        }
        var n = +fromIndex || 0;
        if (Math.abs(n) === Infinity) {
          n = 0;
        }
        if (n >= len) {
          return -1;
        }
        k = Math.max(n >= 0 ? n : len - Math.abs(n), 0);
        while (k < len) {
          if (k in O && O[k] === searchElement) {
            return k;
          }
          k++;
        }
        return -1;
      };
    }

    // Array.every
    // src https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Array/every
    if (!Array.prototype.every) {
      Array.prototype.every = function(fun /*, thisArg */ ) {
        if (this === void 0 || this === null)
          throw new TypeError();
        var t = Object(this);
        var len = t.length >>> 0;
        if (typeof fun !== 'function')
          throw new TypeError();
        var thisArg = arguments.length >= 2 ? arguments[1] : void 0;
        for (var i = 0; i < len; i++) {
          if (i in t && !fun.call(thisArg, t[i], i, t))
            return false;
        }
        return true;
      };
    }
    // Array some 
    Array.prototype.some = function(predicate, o) {
      if (predicate)
        for (var i = 0; i < this.length; i++)
          if (predicate(this[i]))
            return true;
      return false;
    }
  }
  Array.prototype.filter == undefined && (Array.prototype.filter = function(x) {
      if (typeof x == "function") {
        temp = new Array;
        for (i = 0; i < this.length; i++) {
          x(this[i]) && temp.push(this[i]);
        }
        return temp;
      } else {
        return this;
      }
    })
    //console.info = function(){} 
})(window)