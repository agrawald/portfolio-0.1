/**
 * Created by e7006722 on 4/03/14.
 */
Handlebars.registerHelper('list', function(items, options) {
    var out = "<ul>";

    for(var i=0, l=items.length; i<l; i++) {
        if(options.fn(items[i]) == "")
            out = out + "<li>" + items[i] + "</li>";
        else
            out = out + "<li>" + options.fn(items[i]) + "</li>";
    }

    return out + "</ul>";
});

Handlebars.registerHelper('fullName', function(user, options) {
    return options.fn(user).toUpperCase();
});

Handlebars.registerHelper('contact', function(contact, options){
    return options.fn(contact);
});