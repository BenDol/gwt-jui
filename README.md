# GwtJui [![Build Status](https://travis-ci.org/BenDol/gwt-jui.svg?branch=master)](https://travis-ci.org/BenDol/gwt-jui)

GwtJui is a JQueryUI Wrapper for Google Web Toolkit. The objective of this library is to provide easy access to the already existing [JQueryUI](http://jqueryui.com/) Javascript library.

## Getting Started
GwtJui is broken down into 5 subprojects to allow you as the developer to choose the JQuery libraries required. The subprojects are as follows:
* ![completed](http://png.findicons.com/files/icons/1588/farm_fresh_web/16/tick.png) [UI Core](http://api.jqueryui.com/category/ui-core/)
* ![completed](http://png.findicons.com/files/icons/1588/farm_fresh_web/16/tick.png) [Interactions](http://api.jqueryui.com/category/interactions/)
* ![soon](http://people.mozilla.org/~chowse/drop/amo/personas/assets/review-pending.png) [Widgets](http://api.jqueryui.com/category/widgets/)
* ![soon](http://people.mozilla.org/~chowse/drop/amo/personas/assets/review-pending.png) [Effects](http://api.jqueryui.com/category/effects/)
* ![soon](http://people.mozilla.org/~chowse/drop/amo/personas/assets/review-pending.png) [Themes](http://jqueryui.com/themeroller/)

An example using GwtJui is to add the subproject dependecy or dependencies you require.
```xml
<dependency>
    <groupId>nz.co.doltech</groupId>
    <artifactId>gwt-jui-interactions</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

<dependency>
    <groupId>nz.co.doltech</groupId>
    <artifactId>gwt-jui-themes</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
Since all projects require the [core](https://github.com/BenDol/gwt-jui/tree/master/jui-core) module it is automatically inherited for you.

Now that you have the dependency in your project you can add them to your GWT module.
```xml
<!-- Standard use of Interactions -->
<inherits name="nz.co.doltech.gwtjui.interactions.JuiInteractions" />
```
or you can import the module with more extensive information for debugging.
```xml
<!-- Debugging of Interactions, providing non-minified js/css -->
<inherits name="nz.co.doltech.gwtjui.interactions.JuiInteractionsDebug" />
```
Note that the default `Jui` modules assume you have JQuery library already loaded, to make GwtJui load JQuery you can add the following module:
```xml
<!-- Loads JQuery for you -->
<inherits name="nz.co.doltech.gwtjui.core.JuiWithJQuery" />

<!-- Or, same thing for Debugging -->
<inherits name="nz.co.doltech.gwtjui.core.JuiDebugWithJQuery" />
```

now, perhaps you would also like to have a JQuery theme too, you can use them like so:
```java
<inherits name="nz.co.doltech.gwtjui.themes.uilightness.UiLightness" />
```

## Issues
If you find any issues please list them in the [issue tracker](https://github.com/BenDol/gwt-jui/issues) and it will be looked into as soon as possible.

## Contributing
TODO
