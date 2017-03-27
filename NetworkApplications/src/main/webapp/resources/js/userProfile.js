// JavaScript Document

/************ user profile page creation *************/

/** This includes Dom structure for 

1. Edit profile 

*************************************/
function isIE () {
 var ms_ie = false;
    var ua = window.navigator.userAgent;
    var old_ie = ua.indexOf('MSIE ');
    var new_ie = ua.indexOf('Trident/');

    if ((old_ie > -1) || (new_ie > -1)) {
        ms_ie = true;
    }

    return ms_ie ;
}

$(document).ready(function () {
	usrProfile.editProfile(); 
	//usrProfile.logout(); 
	if($(".tz_cityTime")[0]) {
	$(".tz_cityTime")[0].innerHTML =  usrProfile.timeCalculation(-5);
	}
});

/* Begin: change time zone */
var usrProfile = {
	timeCalculation : function( offsetdiff) {
		
		var day = new Array();
		day[0]="Sun";
		day[1]="Mon";
		day[2]="Tue";
		day[3]="Wed";
		day[4]="Thu";
		day[5]="Fri";
		day[6]="Sat";
		
		var aDate = new Date();
		var utc = aDate.getTime() + (aDate.getTimezoneOffset() * 60000);
		
		var newdate = new Date(utc + (3600000* offsetdiff));
		
		 var hour = newdate.getHours()
		 var minute = newdate.getMinutes()
		 var second = newdate.getSeconds()
		 day = (day[newdate.getDay()]);
		 
		  var ap = "AM";
		   if (hour   > 11) { ap = "PM";             }
		   if (hour   > 12) { hour = hour - 12;      }
		   if (hour   == 0) { hour = 12;             }
		   if (hour   < 10) { hour   = "0" + hour;   }
		   if (minute < 10) { minute = "0" + minute; }
		  // if (second < 10) { second = "0" + second; }
		  
		   var timeString =  day + "," + hour + ':' + minute + " " + ap;
		  
			return timeString;			
	},
	timeZone : function(){	
			var that = this;	
			
			var flag = false;		
			
			$(".timeZne").on("click", function(){
				
				that.timeZone_DomManipulation();
				cmnFn.showOverlay("bOverlayId");
				cmnFn.centreScreenCalFn("usrProfileContainer");
				$("#usrProfileContainer").show();
				
				that.timeZone_Onsubmit();
			}); // end of time zone click
	},
	editProfile : function () {
		var that = this;
		$(".editProfile").on("click", function(){
		
				cmnFn.showOverlay("bOverlayId");
				cmnFn.centreScreenCalFn("usrProfileContainer");
				$("#usrProfileContainer").show();
				that.editProfile_DomManipulation();
			//	that.editProfile_Onsubmit();
					$(".timeZonePopup .closePopUp , .usrProfileContainer .timeZonePopup input#leavePageNo").on("click",function(){
							cmnFn.hideOverlay("bOverlayId");
							cmnFn.hidePopUp();
							 $(domCreate).remove();
						});
				
		});
		
	},// edit profile.
	editProfile_DomManipulation : function() {
		
		var domCreate;
		var domSection, domButtons;
		
		domCreate =  $("<div class='inner editProfilePopup'>");
		$("<div class='inner popuptitle'  >Spot Deal User - Edit Profile </div>").appendTo(domCreate);
		
		$("<a href='javascript:void(0)' class='closePopUp' />").appendTo(domCreate);
		
		domSection =  $("<section class='inner'>");
		
		$( "<h2 class='tz_title'>Contact Information</h2>" ).appendTo(domSection);
		
		
		contactform = $("<form >");
		
		contactList = $("<ul>");
		
		
		
		contactList.append("<li class='tz_li'> <label class='required'>Salutation:</label><div class='salDrp dropdownInlineBlk'><select id='editProf_salutation' class='custom-select' ><option>Mr.</option><option>Mrs.</option> <option>Miss</option><option>Ms.</option><option>Dr.</option><option>Prof.</option><option>Rev.</option><option>Other</option></select></div> </li>");
			
		contactList.append("<li class='tz_li'> <label class='required'>First Name:</label><input class='editprofInput' type='text'  value='Shell' required='required'> </li>");
			
		contactList.append("<li class='tz_li'> <label class='required'>Last Name:</label><input  class='editprofInput'  type='text'  value='Shell' required='required'> </li>");
			
		contactList.append("<li class='tz_li'> <label class='required'>Email:</label><input class='editprofInput'   type='email'  value='Shell@sap.com' required='required' readOnly> </li>");
			
		contactList.append("<li class='tz_li'> <label class='required'>Phone Number:</label><input class='editprofInput' type='text'  value='(541) 754-3010' required='required'> </li> ");
			
			
			
		domSection1 =  $("<section class='inner'>");
		
		$( "<h2 class='tz_title'>Login Information</h2>" ).appendTo(domSection1);
		
		loginInfo = $("<ul>");	
			
		loginInfo.append("<li class='tz_li'> <label class='required'>Login Id:</label><input class='editprofInput' type='text'  value='Shell@sap.com' required='required' readOnly> </li> ");	
		
		loginInfo.append("<li class='tz_li'> <label class='required' style='line-height: 1em;'>Password:<br/><span style='color:#ccc;'>(at least 8 characters)</span></label><input class='editprofInput' type='text'  value='' required='required'> </li> ");	
		
		loginInfo.append("<li class='tz_li'> <label class='required'>Confirm Password:</label><input class='editprofInput' type='text'  value='' required='required'> </li> ");	
		
		loginInfo.append("<li class='tz_li'> <label class='required'>Password Hint:</label><input class='editprofInput' type='text'  value='' required='required'> </li> ");	
		
		
		domButtons = $("<div class='buttonDiv popupbutton' ><input type='button' value='Submit' class='aigbutton' id='leavePageYes'/><input type='button' value='Cancel' class='aigbutton' id='leavePageNo'/></div>");
		
		
		loginInfo.appendTo(domSection1);
		
		contactList.appendTo(contactform);
		contactform.appendTo(domSection);
		
		domSection.appendTo(domCreate);	
		$("<hr class='clear' style='margin:0px;'>").appendTo(domCreate);
		domSection1.appendTo(domCreate);	
		domButtons.appendTo(domCreate);
		domCreate.appendTo( $(".usrProfileContainer"));	
		
		$(".editProfilePopup .custom-select").each(function(){
		
            $(this).wrap("<span class='select-wrapper'></span>");
            $(this).after("<span class='holder'></span>");
        });
        $(".editProfilePopup .custom-select").change(function(){
            var selectedOption = $(this).find(":selected").text();
            $(this).next(".holder").text(selectedOption);
        }).trigger('change');
		
		$(".tzWrapper").css("left","20%");
		
		$(".editProfilePopup .closePopUp , .usrProfileContainer .editProfilePopup input#leavePageNo,.usrProfileContainer .editProfilePopup input#leavePageYes").on("click",function(){
			cmnFn.hideOverlay("bOverlayId");
			cmnFn.hidePopUp();
			 $(domCreate).remove();
			 $(".tzWrapper").css("left","33%");
		});
		
	}
	
}/* End: change time zone */