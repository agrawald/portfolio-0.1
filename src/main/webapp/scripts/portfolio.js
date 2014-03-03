$(function(){
    var Portfolio = Backbone.Model.extend({
        urlRoot: 'http://localhost:8080/api/portfolio',
        idAttribute: 'user.userId',
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

    var PortfolioView = Backbone.View.extend({
        tagName:'div',
        className: 'portfolio',
        template: _.template($('#tPortfolio').html()),
        initialize: function(){
            this.portfolios = new PortfolioCollection();
            this.portfolios.fetch({
                success: function(response){
                    console.log(response);
                    this.render();
                },
                error: function(response){
                    console.log(response);
                }
            });
        },
        render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });

    var HeaderView = PortfolioView.extend({
        tagName:'div',
        className: 'header',
        template: _.template($('#tHeader').html())
    });

    var AboutView = PortfolioView.extend({
        tagName:'div',
        className: 'about',
        template: _.template($('#tAbout').html())
    });

    var TechnologiesView = PortfolioView.extend({
        tagName:'div',
        className: 'technologies',
        template: _.template($('#tTechnologies').html())
    });

    var TestimonialsView = PortfolioView.extend({
        tagName:'div',
        className: 'testimonials',
        template: _.template($('#tTestimonials').html())
    });

    var ContactMeView = Backbone.View.extend({
        tagName:'div',
        className: 'contactMe',
        initialize: function(){
        },
        render: function(){
        }
    });

    var PortfolioRouter = Backbone.Router.extend({
        routes:{
            '':'about',
            'about': 'about',
            'portfolio': 'portfolio',
            'technologies': 'technologies',
            'testimonials': 'testimonials',
            'contactMe': 'contactMe',
            'download' : 'download'
        },
        initialize: function(){
          new HeaderView();
        },
        about: function(){
            return new AboutView();
        },
        portfolio: function(){
            return new PortfolioView();
        },
        technologies: function(){
            return new TechnologiesView();
        },
        testimonials: function(){
            return new TestimonialsView();
        },
        contactMe: function(){
            return new ContactMeView();
        },
        download: function(){
            //TODO
        }
    });

    var portfolio_router = new PortfolioRouter();
    Backbone.history.start();
});
