// JavaScript Document
$(document).ready(function () {
	 dashObj.navMenufunc();
	 dashObj.logoutfun(); 	
});
/* side menu function */
var dashObj = {
	navMenufunc : function(){
			$('#nav > li > a').click(function(){
				if ($(this).attr('class') != 'active'){
				  $('#nav li ul').slideUp();
				  $(this).next().slideToggle();
				  $('#nav li a').removeClass('active');
				  $(this).addClass('active');
				}
			  });
			$(".dropdown dt a").click(function() {
				$(".dropdown dd ul").toggle();
			});
			
			$(".dropdown dd ul li a").click(function() {
				var text = $(this).html();
				//$(".dropdown dt a span").html(text);
				$(".dropdown dd ul").hide();
			}); 
			
			$(document).bind('click', function(e) {
				var $clicked = $(e.target);
				if (! $clicked.parents().hasClass("dropdown"))
					$(".dropdown dd ul").hide();
			});

	}, //navObj
	logoutfun : function() {
		
			$(".logout").on("click", function(){
				cmnFn.showOverlay("bOverlayId");
				cmnFn.centreScreenCalFn("pageLeaveConfirmationId");
				$("#pageLeaveConfirmationId").show();
				$("#loginMsg").show();
				$("#saveMsg").hide();
				$("#confirmMsg").hide();
			
			$("#pageLeaveConfirmationId").css("top",cmnFn.centreScreenCalFn("pageLeaveConfirmationId"))
			if($(document).width() <= 320){
					$("#leavePageYes, #leavePageNo").css({float:"none", width:"80%", "text-align":"center", "margin":"0 auto 20px"})							
					//$("#leavePageNo").addClass("noMarginBottom")
			}
			$("input#leavePageNo, input#leavePageYes").off();
			
			$("input#leavePageNo").on("click",function(){	
				$("#pageLeaveConfirmationId").hide();
				cmnFn.hideOverlay("bOverlayId")
				
			})
			$("input#leavePageYes").on("click",function(){				
					window.location = "index.html";	
			});
		});
				
	}
}

var cmnFn = {	

	getDocHeight: function () {
		var bodyHt = $(document).height(), 
			viewPortHt = $(window).height(),  
			bodyWdt = $("body").width(), 
			viewPortWdt = $(window).width(), 
			documentHeight, 
			documentWidth;		
			
		if(bodyHt > viewPortHt){
			documentHeight = bodyHt;
		}else{
			documentHeight = viewPortHt;
		}		
		if(bodyWdt > viewPortWdt){
			documentWidth = bodyWdt;
		}else{
			documentWidth = viewPortWdt;
		}        
        return {
            width: documentWidth,
            height: documentHeight
        };
    },
	centreScreenCalFn: function(popUpObj){		
		var scrTop = $(document).scrollTop();
		var screenHeight = $(window).height();
		var topPos = scrTop+((screenHeight/2)-$("#"+popUpObj).height());
		//console.log($("#"+popUpObj).height())
		return topPos;
	},
	
	showOverlay : function(overlayId, loadingImgId){
		if(loadingImgId){
			$("#"+overlayId +", #"+loadingImgId).css({"display":"block"});
			$("#"+loadingImgId).css("top", cmnFn.centreScreenCalFn(loadingImgId));
		}else{
			$("#"+overlayId).css("display","block");
		}
		$("#"+overlayId).css("height",this.getDocHeight().height+"px");
	},
	
	hideOverlay : function(overlayId, loadingImgId){
		$("#"+overlayId +", #"+loadingImgId).css("display","none");
	},
	
	showPopUp : function(popUpObj){
		
		var popUpDiv;
		if(popUpObj){
		 popUpDiv= "#"+popUpObj
		} else {
			popUpDiv = ".popUpDiv";
		}
		if($(popUpDiv).css("display")!== "block"){
			var screenCal = $(window).height() - $(popUpDiv).height();
			this.showOverlay("bOverlayId");
			var scrTop = $(document).scrollTop();
			$(popUpDiv).css({"display":"block", "top":scrTop+(screenCal/3)})
		}
	},
	
	hidePopUp : function(){
		$(".popUpDiv").css({"display":"none"})
	},
	
	paginator : function(items, countperPage, maxLimit){
		        var numItems = items.length;
				
                var perPage = countperPage;
                // only show the first 2 (or "first per_page") items initially
               
			   if(parseInt(countperPage) < parseInt(maxLimit) ) { 
			     items.slice(perPage).hide(); 
			 }
				else {
					items.show();
				
	
				}
			   // now setup pagination
                $(".pagination").pagination({
				
                    items: numItems,
                    itemsOnPage: perPage,
                    cssStyle: "light-theme",
                    onPageClick: function(pageNumber) { // this is where the magic happens
                        // someone changed page, lets hide/show trs appropriately
		
                        var showFrom = perPage * (pageNumber-1);
                        var showTo = showFrom + perPage;
                        items.hide() // first hide everything, then show for the new page
                             items.slice(showFrom, showTo).show();
                    }
						
                });
	}


}// cmnFn

