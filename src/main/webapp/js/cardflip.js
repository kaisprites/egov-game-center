/**
 * 
 */
	$(function(){
		var timestamp;
	    var gameboard = new Array(12);
	    var score = 0;
	    var flipable = false;
	    var flipping = false;
	    var previousNumber = -1;
	    var currentNumber = -1;
	    var correctGameboard = new Array(12).fill(false);
	    $("#card00").click(_=>{reveal(0)})
	    $("#card01").click(_=>{reveal(1)})
	    $("#card02").click(_=>{reveal(2)})
	    $("#card03").click(_=>{reveal(3)})
	    $("#card04").click(_=>{reveal(4)})
	    $("#card05").click(_=>{reveal(5)})
	    $("#card06").click(_=>{reveal(6)})
	    $("#card07").click(_=>{reveal(7)})
	    $("#card08").click(_=>{reveal(8)})
	    $("#card09").click(_=>{reveal(9)})
	    $("#card10").click(_=>{reveal(10)})
	    $("#card11").click(_=>{reveal(11)})
	    $("#gameStart").click(Initialize)
	    $("#forward").click(_=>{window.history.back()})
	
	    function Initialize() {
	    	timestamp = +new Date()
	        document.getElementsByTagName("input")[0].value = "게임 재개";
	        score = 0;
	        document.getElementsByClassName("score")[0].innerHTML = score;
	        var mountain = "☆□♧○△♡☆□♧○△♡";
	        for(i=0; i<12; i++)
	        {
	            document.getElementsByClassName("card")[i].innerHTML = "";
	
	            var rannum = Math.floor(Math.random()*(12-i));
	            gameboard[i] = mountain[rannum];
	            mountain = mountain.substr(0,rannum)+mountain.substr(rannum+1,11-i);
	        }
	
	        flipable = true;
	        flipping = false;
	        previousNumber = -1;
	        currentNumber = -1;
	        correctGameboard = new Array(12).fill(false);
	    }
	    
	    function reveal(number) {
	        if(!correctGameboard[number] && flipable && previousNumber != number) {
	            currentNumber = number;
	            document.getElementsByClassName("card")[number].innerHTML = gameboard[number];
	            if(flipping)
	            {
	                flipable = false;
	                setTimeout(flipTimeout, 500, currentNumber);
	                flipping = false;
	                score++;
	                document.getElementsByClassName("score")[0].innerHTML = score;
	            }
	            else
	            {
	                previousNumber = number;
	                flipping = true;
	            }
	        }
	    }
	
	    function flipTimeout(number)
	    {
	        if(gameboard[previousNumber] == gameboard[number])
	        {
	            correctGameboard[previousNumber] = true
	            correctGameboard[number] = true
	        }
	        else
	        {
	            document.getElementsByClassName("card")[number].innerHTML = ""
	            document.getElementsByClassName("card")[previousNumber].innerHTML = ""
	        }
	
	        if(correctGameboard.filter(element => element == true).length == 12)
	        {
	            var cards = document.getElementsByClassName("card")
	            cards[0].innerHTML = ""
	            cards[1].innerHTML = "게"
	            cards[2].innerHTML = "임"
	            cards[3].innerHTML = ""
	            cards[4].innerHTML = ""
	            cards[5].innerHTML = "완"
	            cards[6].innerHTML = "료"
	            cards[7].innerHTML = ""
	            cards[8].innerHTML = "CONG"
	            cards[9].innerHTML = "LAT"
	            cards[10].innerHTML = "URA"
	            cards[11].innerHTML = "TION"
	            	
	            if(id != '') {
		            $.ajax({
		            	url: "cardflip.do",
		            	method: "post",
		            	data: {
		            		id: id,
		            		cardflip: +new Date() - timestamp
		            	}
		            })
	        	}
	        }
	        else flipable = true
	    }
	})