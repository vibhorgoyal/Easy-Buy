<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EasyBuy</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">



    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script type="text/javascript">
    function create( a ,  b , c) {
        console.log("hi");
        var chart = new Highcharts.Chart({
            chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            renderTo: 'conta',
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Reviews of the Product'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: 'blue' || 'green' || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'Reviews',
            colorByPoint: true,
            data: [{
                name: 'Positive',
                y: a,
                sliced:true
            }, {
                name: 'Negative',
                y: b,
                sliced: true,
            
            }, {
                name: 'Neutral',
                y: c,
                sliced:true
            }]
        }]
    });
}
</script>
<style>
.se-pre-con {
    position: fixed;
    left: 0px;
    top: 0px;
    margin-left: 43%;
    margin-top: 20%;
    width: 14%;
    height: 20%;
    z-index: 9999;
    
}
 </style>

    <script type="text/javascript">
 function loader()
  {
    if(document.getElementById('usr').value.trim()=="")
        return;
    console.log("aja");
    document.getElementById('img').setAttribute("class","se-pre-con");
    document.getElementById('img').style.display="inline";
    document.getElementById('img').setAttribute("src","./spin.gif");
    console.log("aja");
  }
</script>    



    </head>

<body id="page-top" onload="create(<%= request.getAttribute("Positive") %>,
 <%= request.getAttribute("Negative") %>,
 <%= request.getAttribute("Neutral") %>)">
 

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top" style="background-color: <%= request.getAttribute("color") %>">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="index.html" style="color: white">EasyBuy<sup>beta</sup></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            

            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

<header style="background:none">
    
<section>
   <div id="conta" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
   <!-- Trigger the modal with a button -->
<% ArrayList<String> p = (ArrayList<String>)request.getAttribute("posReview"); %>

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" 
style="background-color: <%=request.getAttribute("color") %>" >
Top <%=p.size() %> positive reviews
</button>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content" style="color: black">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">top <%= p.size() %> results based upon sentiment score of Alchmey API</h4>
      </div>
      <div class="modal-body">
        <p>
            <% int i =0;
            for(i=0;i<p.size();i++)
                {%>
                    <%= p.get(i) %>
                    <br>
                    <br>
                 <%
                 }
            %>
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<%ArrayList<String> n = (ArrayList<String>)request.getAttribute("negReview"); %>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal1" style="background-color:<%= request.getAttribute("color") %> ">Top <%=n.size() %> negative reviews</button>


<!-- Modal -->
<div id="myModal1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content" style="color: black">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">top <%= n.size() %> results based upon sentiment score of Alchmey API</h4>
      </div>
      <div class="modal-body">
        <p>
            <% int j =0;
            for(j=0;j<n.size();j++)
                {%>
                    <%= j %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <%= n.get(j) %>
                    <br>
                    <br>
                 <%
                 }
            %>
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</section>
</header>
      <!--<section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">We've got what you need!</h2>
                    <hr class="light">
                    <p class="text-faded">You just enter the product url and we provide you with a summarized version of all the reviews.</p>
                    <a href="#services" class="page-scroll btn btn-default btn-xl sr-button">Get Started!</a>
                </div>
            </div>
        </div>
    </section>
!-->
    <section id="services" class="bg-success">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Got Another Product ?</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
              <img src="" id="img" style="display:none"  />
  
        <div class="container">
            <form action="abc" method="post">
            <div class="row">
                <div class="form-group">
                    <label for="usr">Product URL</label>
                    <input type="url" class="form-control" id="usr" name="usr" placeholder="Enter your product url here!" required>
                </div>    
             </div>
             <br><br>
             <div class="row">
                    <div class="container text-center">
                         <input type="submit" class=" btn btn-info btn-lg" onclick="loader()">
                    </div>
                </div>
            </form>
        </div>
    </section>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/scrollreveal.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>

</body>

</html>
