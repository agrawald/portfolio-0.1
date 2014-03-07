$(function(){
    var Portfolio = Backbone.Model.extend({
        urlRoot: 'http://localhost:8080/api/portfolio',
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
            $('#tabs').tabs();
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
        template: $('#tContactMe').html()
    });

    var PortfolioRouter = Backbone.Router.extend({
        routes:{
            //'':'about',
            'click #rb-about': 'about',
            'click input[id=rb-portfolio]': 'portfolio',
            'click input[id=rb-technologies]': 'technologies',
            'click input[id=rb-testimonials]': 'testimonials',
            'click input[id=rb-contact_me]': 'contactMe',
            'click input[id=rb-download]' : 'download'
        },
        v_shown: '',
        initialize: function(){
            this.header();
            this.portfolio();
            this.technologies();
            this.testimonials();
            this.contactMe();
            this.v_shown=this.about();

            $('#radioset').buttonset();
            $('#rb-about').button();
            $('#rb-portfolio').button();
            $('#rb-technologies').button();
            $('#rb-testimonials').button();
            $('#rb-contact-me').button();
        },
        header: function(){
            var v_header = new HeaderView();
            v_header.render();
            $('#download').button();
            $('#linkedInUrl').button();
            return v_header;
        },
        about: function(){
            alert("Clicked about");
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
                    left: '100%'
                }, 1500);
            }
            this.v_shown = v_to_show;
            v_to_show.render();
            v_to_show.$el.stop().animate({
                'left': '10px'
            }, 1500);
            return v_to_show;
        }
    });

    var portfolio_router = new PortfolioRouter();
    Backbone.history.start();
});
