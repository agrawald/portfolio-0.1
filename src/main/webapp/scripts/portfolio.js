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
        initialize: function(){
            var _this = this;
            var collection= new PortfolioCollection();
            collection.fetch({
                success: function(collection){
                    _.each(collection.models, function(model){
                        if(model.attributes.enabled)
                            _this.render(model)
                    })
                }
            });
        },
        render: function(model){
            if(!_.isUndefined(model))
            {
                console.log("In render" + model);
                var hb_template = Handlebars.compile(this.template);
                var html = hb_template(model.toJSON());
                this.$el.html(html);
            }
            $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
            $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );

            return this;
        }
    });

    var PortfolioView = GenericView.extend({
        el:'#portfolio',
        template: $('#tPortfolio').html()
    });

    var HeaderView = GenericView.extend({
        el: '#header',
        template: $('#tHeader').html()
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
            var _this = GenericView.prototype.render.call(this);
            $('#submit').button().click(function (event) {
                return this.submit(event);
            });
            return _this;
        },
        submit: function (event) {
            console.log(event);
            event.preventDefault();
            var contactme = new ContactMe();
            contactme.create({
                name: $('#name').value(),
                email: $('#email').value(),
                contact: $('#contact').value(),
                message: $('#message').value()
            });
        }
    });

    var PortfolioRouter = Backbone.Router.extend({
        routes:{
            '': 'about'
        },
        v_shown: '',
        initialize: function(){
            var _this = this;
            this.header();
            this.v_shown=this.about();

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
            $('#download').button();
            $('#linkedInUrl').button();
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
        download: function(){
            //TODO
        },
        showView: function(v_to_show)
        {
            if(!_.isEmpty(this.v_shown))
            {
              this.v_shown.$el.stop().animate({
                  top: '100%'
              }, 1500);
            }
            this.v_shown = v_to_show;
            v_to_show.render();
            v_to_show.$el.stop().animate({
                'top': '120px'
            }, 1500);
            return v_to_show;
        }
    });

    var portfolio_router = new PortfolioRouter();
    Backbone.history.start();
});
