/**
 * Created by e7006722 on 4/03/14.
 */
Handlebars.registerHelper('list', function(items, options) {
    var out = "<ol>";

    for(var i=0, l=items.length; i<l; i++) {
        if(options.fn(items[i]) == "")
            out = out + "<li>" + items[i] + "</li>";
        else
            out = out + "<li>" + options.fn(items[i]) + "</li>";
    }

    return out + "</ol>";
});

Handlebars.registerHelper('projectTech', function (items) {
    var out = "";

    for (var i = 0, l = items.length; i < l; i++) {
        out = out + items[i].name;
        if (i != l - 1)
            out += ", ";
    }

    return out;
});


Handlebars.registerHelper('technology', function (items, options) {
    var out = "";

    for (var i = 0, l = items.length; i < l; i++) {
        if (options.fn(items[i]) == "")
            out = out + " " + items[i] + " ";
        else
            out = out + " " + options.fn(items[i]) + " ";
    }

    return out;
});

Handlebars.registerHelper('fullName', function(user, options) {
    return options.fn(user).toUpperCase();
});

Handlebars.registerHelper('contact', function(contact, options){
    return options.fn(contact);
});

Handlebars.registerHelper('tabs', function(organisations, options){
    var out ="<ul class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all' role='tablist'>";

    for(var i=0, l=organisations.length; i<l; i++) {
        if(i==0)
            out+="<li class='ui-state-default ui-corner-top ui-tabs-active ui-state-active' " +
                "role='tab' tabindex='0' aria-controls='tabs-"+(i+1)+"' aria-labelledby='ui-id-"+(i+2)+"' " +
                "aria-selected='true'><a href='#tabs-"+(i+1)+"' class='ui-tabs-anchor' role='presentation' " +
                "tabindex='-1' id='ui-id-"+(i+2)+"'>"+organisations[i].name+"</a></li>";
        else
            out+="<li class='ui-state-default ui-corner-top' role='tab' tabindex='-1' " +
                "aria-controls='tabs-"+(i+1)+"' aria-labelledby='ui-id-"+(i+2)+"' aria-selected='false'>" +
                "<a href='#tabs-"+(i+1)+"' class='ui-tabs-anchor' role='presentation' " +
                "tabindex='-1' id='ui-id-"+(i+2)+"'>"+organisations[i].name+"</a></li>";
    }

    out+="</ul>";

    for(var i=0, l=organisations.length; i<l; i++) {
        out+="<div id='tabs-"+(i+1)+"' aria-labelledby='ui-id-"+(i+2)+"' " +
            "class='ui-tabs-panel ui-widget-content ui-corner-bottom' role='tabpanel' ";

        if(i==0)
            out += "aria-expanded='true' aria-hidden='false' style='display: block;overflow: auto;'>";
        else
            out += "aria-expanded='false' aria-hidden='true' style='display: none;overflow: auto;'>"

        out+=options.fn(organisations[i])+"</div>";
    }

    return out + "</div>";
});
