<html>
  <head>
    <meta charset="utf-8">
    <title>Form</title>
    <link href="./resources/css/binstyle.css" type="text/css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
  </head>
  <body>
    <!-- Body of Form starts -->
  	<div class="container">
      <form method="post" action="servlet/Register" >
       <!--Employee Id-->
    		<div class="box">
          <label for="firstName" class="fl fontLabel"> Employee Id: </label>
    			<div class="fr">
    					<input type="text" name="userId" placeholder="Office Employee Id"
              class="textBox" autofocus="on" required>
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--Employee Id-->
        <!--First name-->
    		<div class="box">
          <label for="firstName" class="fl fontLabel"> First Name: </label>
    			<div class="fr">
    					<input type="text" name="firstName" placeholder="First Name"
              class="textBox" autofocus="on" required>
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--First name-->


        <!--Second name-->
    		<div class="box">
          <label for="secondName" class="fl fontLabel"> Last Name: </label>
    			
    			<div class="fr">
    					<input type="text" required name="lastName"
              placeholder="Last Name" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--Second name-->


    		<!---Phone No.------>
    		<div class="box">
          <label for="phone" class="fl fontLabel"> API Key: </label>
    			
    			<div class="fr">
    					<input type="text" required name="akey"  placeholder="Binance API Key" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Phone No.---->

			<!---Phone No.------>
    		<div class="box">
          <label for="phone" class="fl fontLabel"> Secret Key.: </label>
    			
    			<div class="fr">
    					<input type="text" required name="skey" maxlength="10" placeholder="Binance Secret Key" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Phone No.---->
    		
    		<!---Email ID---->
    		<div class="box">
          <label for="email" class="fl fontLabel"> Email ID: </label>
    			
    			<div class="fr">
    					<input type="email" required name="email" placeholder="Official Email Id" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!--Email ID----->


    		<!---Password------>
    		<div class="box">
          <label for="password" class="fl fontLabel"> Password </label>
    			
    			<div class="fr">
    					<input type="Password" required name="password" placeholder="Password" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		
    		<div class="box">
          <label for="password" class="fl fontLabel"> Confirm Password </label>
    			
    			<div class="fr">
    					<input type="Password" required name="cpassword" placeholder="Re Enter Password" class="textBox">
    			</div>
    			<div class="clr"></div>
    		</div>
    		<!---Password---->

    		
    		
          


    		<!--Terms and Conditions------>
    		<div class="box terms">
    				<input type="checkbox" name="Terms" required> &nbsp; I accept the terms and conditions
    		</div>
    		<!--Terms and Conditions------>



    		<!---Submit Button------>
    		<div class="box" style="background: #2d3e3f">
    				<input type="Submit" name="Submit" class="submit" value="SUBMIT">
    		</div>
    		<!---Submit Button----->
      </form>
  </div>
  <!--Body of Form ends--->
  </body>
</html>
