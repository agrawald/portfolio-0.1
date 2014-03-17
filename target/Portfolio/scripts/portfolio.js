$(function(){
    var Portfolio = Backbone.Model.extend({
        urlRoot: 'http://localhost:8080/api/portfolio',
        idAttribute: 'id',
        url: function(){
            return this.urlRoot;
        }
    });

    var ContactMe = Backbone.Model.extend({
        urlRoot: 'http://localhost:8080/api/contact/dagrawal',
        idAttribute: 'id',
        url: function(){
            return this.urlRoot;
        }
    });

    var PortfolioCollection = Backbone.Collection.extend({
        userId: 'dagrawal',
        model: Portfolio,
        url:function(){
            return 'http://localhost:8080/api/portfolio/' + this.userId;
        },
        getEnabled:function(){
            return this.where({enabled: true});
        }
    });

    var GenericView = Backbone.View.extend({
        collections: new PortfolioCollection(),
        initialize: function(){
            var _this = this;
            this.collections.fetch({
                success: function(collection){
                    _this.onSuccessHandler(collection);
                }
            });
        },
        onSuccessHandler: function(collection){
            var _this = this;
            _.each(collection.models, function(model){
                if(model.attributes.enabled)
                    _this.render(model)
            })
        },
        render: function(model){
            if(!_.isUndefined(model))
            {
                console.log("In render" + model);
                var hb_template = Handlebars.compile(this.template);
                var html = hb_template(model.toJSON());
                this.$el.html(html);
            }

            return this;
        }
    });

    var DialogView = Backbone.View.extend({
        el:'#dialog',
        template: $('#tDialog').html(),
        render: function(model){
            if(!_.isUndefined(model))
            {
                console.log("In render" + model);
                var hb_template = Handlebars.compile(this.template);
                var html = hb_template(model);
                this.$el.html(html);
                $('#dialog').dialog();
            }
        }
    });

    var PortfolioView = GenericView.extend({
        el:'#portfolio',
        template: $('#tPortfolio').html(),
        render: function(model){
            var _this = GenericView.prototype.render.call(this, model);
            this.addHandlers();
            return _this;
        },
        addHandlers:function(){
            $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
            $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
        }
    });

    var HeaderView = GenericView.extend({
        el: '#header',
        template: $('#tHeader').html(),
        render:function(model){
            var _this = GenericView.prototype.render.call(this, model);
            this.addHandlers();
            return _this;
        },
        addHandlers: function(){
            $('#download').button();
            $('#linkedInUrl').button();
        }
    });

    var AboutView = GenericView.extend({
        el: '#about',
        template: $('#tAbout').html()
    });

    var TechnologiesView = GenericView.extend({
        el: '#technologies',
        template: $('#tTechnologies').html()
    });

    var TestimonialsView = GenericView.extend({
        el: '#testimonials',
        template: $('#tTestimonials').html()
    });

    var ContactMeView = GenericView.extend({
        el: '#contactMe',
        template: $('#tContactMe').html(),
        render: function(model){
            var _this = GenericView.prototype.render.call(this, model);
            this.addHandlers();
            return _this;
        },
        submit: function (event) {
            console.log(event);
            event.preventDefault();
            var contact = new ContactMe();
            contact.save({
                name: $('#name').val(),
                email: $('#email').val(),
                contact: $('#contact').val(),
                message: $('#message').val(),
                userId: $('#userId').val()
            }, {
                error: function(model, response){
                    return new DialogView().render(response);
                },
                success:function(model, response){
                    return new DialogView().render(response);
                }
            });
        },
        addHandlers: function(){
            var _this = this;
            $('#submit').button().click(function (event) {
                return _this.submit(event);
            });
        }
    });

    var PortfolioRouter = Backbone.Router.extend({
        routes:{
            '': 'about'
        },
        v_shown: '',
        initialize: function(){
            this.header();
            this.v_shown=this.about();
            this.addHandlers();
        },
        addHandlers: function(){
            var _this = this;
            $('#radioset').buttonset();
            $('#rb-about').button().click(function (event) {
                return _this.about();
            });
            $('#rb-portfolio').button().click(function (event) {
                return _this.portfolio();
            });
            $('#rb-technologies').button().click(function (event) {
                return _this.technologies();
            });
            ;
            $('#rb-testimonials').button().click(function (event) {
                return _this.testimonials();
            });
            ;
            $('#rb-contact-me').button().click(function (event) {
                return _this.contactMe();
            });
        },
        header: function(){
            var v_header = new HeaderView();
            v_header.render();
            return v_header;
        },
        about: function(){
            return this.showView(new AboutView());
        },
        portfolio: function(){
            return this.showView(new PortfolioView());
        },
        technologies: function(){
            return this.showView(new TechnologiesView());
        },
        testimonials: function(){
            return this.showView(new TestimonialsView());
        },
        contactMe: function(){
            return this.showView(new ContactMeView());
        },
        showView: function(v_to_show)
        {
            if(!_.isEmpty(this.v_shown))
            {
              this.v_shown.el.style.display='none';
              this.v_shown.$el.stop().animate({
                  top: '100%'
              }, 1500);
            }
            this.v_shown = v_to_show;
            v_to_show.render();
            v_to_show.el.style.display = "block";
            v_to_show.$el.stop().animate({
                'top': '80px'
            }, 1500,"easeOutQuart");
            return v_to_show;
        }
    });

    var portfolio_router = new PortfolioRouter();
    Backbone.history.start();
});
