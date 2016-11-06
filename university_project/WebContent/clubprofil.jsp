<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sailor - Bootstrap 3 corporate template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description"
	content="Bootstrap 3 template for corporate business" />
<meta name="author" content="http://iweb-studio.com" />
<!-- css -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/cubeportfolio.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />

<!-- Theme skin -->
<link id="t-colors" href="skins/default.css" rel="stylesheet" />

<!-- boxed bg -->
<link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>


	<div id="wrapper">
		<!-- start header -->
		<header>

			<div class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="indexservlet"><img
							src="img/logo.png" alt="" width="199" height="52" /></a>
					</div>
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">


							<li><a href="indexservlet">Accueil</a></li>
							<li><a href="apropos.html">A propos de Smart University</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">Actualit�s <i
									class="fa fa-angle-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="emplois.html">Emploi de Temps</a></li>
									<li><a href="fichier.html">Fichier Admnistratif</a></li>
									<li><a href="autre.html">Autre</a></li>
								</ul></li>

							<li class="active" class="dropdown"><a href="#"
								class="dropdown-toggle " data-toggle="dropdown"
								data-hover="dropdown" data-delay="0" data-close-others="false">Formation<i
									class="fa fa-angle-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="formationprep.html">Formation
											Preparatoire</a></li>
									<li><a href="formationlicence.html">Formation licence
									</a></li>
									<li><a href="formationmastere.html">Formation Mastere</a></li>
									<li><a href="formationing.html">Formation Ingenieur</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">Entreprenariat <i
									class="fa fa-angle-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="blog-rightsidebar.html">Blog right
											sidebar</a></li>
									<li><a href="blog-leftsidebar.html">Blog left sidebar</a></li>
									<li><a href="post-rightsidebar.html">Post right
											sidebar</a></li>
									<li><a href="post-leftsidebar.html">Post left sidebar</a></li>
								</ul></li>

							<li><a href="contact.html">Contact</a></li>
						</ul>
					</div>
				</div>
			</div>

		</header>
		<!-- end header -->
		<section id="inner-headline">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<ul class="breadcrumb">
							<li><a href="#"><i class="fa fa-home"></i></a></li>
							<li class="active"><c:out value="${club.nom }"></c:out></li>
						</ul>
					</div>
				</div>
			</div>
		</section>

		<section id="content">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<article>
							<div class="post-image">
								<div class="post-heading">
									<h3>
										<a href="#"><c:out value="${activity.nom }"></c:out></a>
									</h3>
								</div>
								<img src="img/dummies/blog/img4.jpg" alt=""
									class="img-responsive" />
							</div>
							<p><c:out value="${activity.description }"></c:out> Cu eos sale sanctus eligendi,
								id ius elitr saperet, ocurreret pertinacia pri an. No mei nibh
								consectetuer, semper laoreet perfecto ad qui, est rebum nulla
								argumentum ei. Fierent adipisci iracundia est ei, usu timeam
								persius ea. Usu ea justo malis, pri quando everti electram ei,
								ex homero omittam salutatus sed.</p>
							<div class="bottom-article">
								<ul class="meta-post">
									<li><i class="fa fa-calendar"></i><a href="#"> Mar 27,
											2014</a></li>
									<li><i class="fa fa-user"></i><a href="#"> Admin</a></li>
									<li><i class="fa fa-folder-open"></i><a href="#"> Blog</a></li>
									<li><i class="fa fa-comments"></i><a href="#">4
											Comments</a></li>
								</ul>
								<a href="#" class="readmore pull-right">Continue reading <i
									class="fa fa-angle-right"></i></a>
							</div>
						</article>

						<article>
							<div class="post-slider">
								<div class="post-heading">
									<h3>
										<a href="#">This is an example of slider post format</a>
									</h3>
								</div>
								<!-- start flexslider -->
								<div id="post-slider" class="postslider flexslider">
									<ul class="slides">
										<li><img src="img/dummies/blog/img4.jpg" alt="" /></li>
										<li><img src="img/dummies/blog/img7.jpg" alt="" /></li>
										<li><img src="img/dummies/blog/img8.jpg" alt="" /></li>
									</ul>
								</div>
								<!-- end flexslider -->
							</div>
<!-- 							<p>Qui ut ceteros comprehensam. Cu eos sale sanctus eligendi, -->
<!-- 								id ius elitr saperet, ocurreret pertinacia pri an. No mei nibh -->
<!-- 								consectetuer, semper laoreet perfecto ad qui, est rebum nulla -->
<!-- 								argumentum ei. Fierent adipisci iracundia est ei, usu timeam -->
<!-- 								persius ea. Usu ea justo malis, pri quando everti electram ei, -->
<!-- 								ex homero omittam salutatus sed.</p> -->
							<div class="bottom-article">
								<ul class="meta-post">
									<li><i class="fa fa-calendar"></i><a href="#"> May 17,
											2014</a></li>
									<li><i class="fa fa-user"></i><a href="#"> Admin</a></li>
									<li><i class="fa fa-folder-open"></i><a href="#"> </a></li>
									<li><i class="fa fa-comments"></i><a href="#"></a></li>
								</ul>
								<a href="#" class="readmore pull-right"> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</article>
						<article>
							<div class="post-quote">
								<div class="post-heading">
									<h3>
										<a href="#">Nice example of quote post format below</a>
									</h3>
								</div>
								<blockquote>
									<i class="fa fa-quote-left"></i> Lorem ipsum dolor sit amet, ei
									quod constituto qui. Summo labores
								</blockquote>
							</div>
							<div class="bottom-article">
								<ul class="meta-post">
									<li><i class="fa fa-calendar"></i><a href="#"> May 17,
											2014</a></li>
									<li><i class="fa fa-user"></i><a href="#"> Admin</a></li>
									<li><i class="fa fa-folder-open"></i><a href="#"> Blog</a></li>
									<li><i class="fa fa-comments"></i><a href="#">4
											Comments</a></li>
								</ul>
								<a href="#" class="readmore pull-right"> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</article>
						<article>
							<div class="post-video">
								<div class="post-heading">
									<h3>
										<a href="#">Amazing video post format here</a>
									</h3>
								</div>
								<div class="video-container">
									<iframe
										src="http://player.vimeo.com/video/30585464?title=0&amp;byline=0">
									</iframe>
								</div>
							</div>
							<p>Qui ut ceteros comprehensam. Cu eos sale sanctus eligendi,
								id ius elitr saperet, ocurreret pertinacia pri an. No mei nibh
								consectetuer, semper laoreet perfecto ad qui, est rebum nulla
								argumentum ei. Fierent adipisci iracundia est ei, usu timeam
								persius ea. Usu ea justo malis, pri quando everti electram ei.</p>
							<div class="bottom-article">
								<ul class="meta-post">
									<li><i class="fa fa-calendar"></i><a href="#"> May 17,
											2014</a></li>
									<li><i class="fa fa-user"></i><a href="#"> Admin</a></li>
									<li><i class="fa fa-folder-open"></i><a href="#"> Blog</a></li>
									<li><i class="fa fa-comments"></i><a href="#">4
											Comments</a></li>
								</ul>
								<a href="#" class="readmore pull-right">Continue reading <i
									class="fa fa-angle-right"></i></a>
							</div>
						</article>
						<div id="pagination">
							<span class="all">Page 1 of 3</span> <span class="current">1</span>
							<a href="#" class="inactive">2</a> <a href="#" class="inactive">3</a>
						</div>
						<div class="clear"></div>
					</div>
					<div class="col-lg-4">
						<aside class="right-sidebar">
							<div class="widget">
								<form role="form">
									<div class="form-group">
										<input type="text" class="form-control" id="s"
											placeholder="Search..">
									</div>
								</form>
							</div>
							<div class="widget">
								<h5 class="widgetheading">
									<c:out value="${club.nom }"></c:out>
								</h5>
								<ul class="cat">
									<li><i class="fa fa-angle-right"></i>
									<c:out value="${club.nom }"></c:out></li>
									<li><i class="fa fa-angle-right"></i>
									<c:out value="${club.caractere }"></c:out></li>
									<li><i class="fa fa-angle-right"></i>
									<c:out value="${enseignant.nomuser }"></c:out></li>
									<li><i class="fa fa-angle-right"></i>activity prochain <c:out
											value="${activity.nom }"></c:out></li>
								</ul>
							</div>
							<div class="widget">
								<h5 class="widgetheading">Latest posts</h5>
								<ul class="recent">
									<c:forEach items="${activities}" var="p">

										<li><img src="img/dummies/blog/65x65/thumb1.jpg"
											class="pull-left" alt="" />
											<h6>
												<a href="infoclub?idc=${p.idclub}&idac=${p.idactivity } ">${p.nom }</a>
											</h6>
											<p>${p.description }
											</p></li>

										</c:forEach>
								</ul>
							</div>
							<div class="widget">
								<h5 class="widgetheading">Encadreur</h5>
								<ul class="cat"><a href="infoenseignant">
									<li><c:out value="${enseignant.nomuser }"></c:out></li>
									<li><c:out value="${enseignant.prenom }"></c:out></li></a>
									<li><c:out value="${enseignant.telephone }"></c:out></li>
									<li><c:out value="${enseignant.email }"></c:out> </li>
									<li><c:out value="${enseignant.gradeEnseignant }"></c:out> </li>
									
								</ul>
							</div>
						</aside>
					</div>
				</div>
			</div>
		</section>
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-sm-3 col-lg-3">
						<div class="widget">
							<h4>Get in touch with us</h4>
							<address>
								<strong>Sailor company Inc</strong><br> Sailor suite room
								V124, DB 91<br> Someplace 71745 Earth
							</address>
							<p>
								<i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
								<i class="icon-envelope-alt"></i> email@domainname.com
							</p>
						</div>
					</div>
					<div class="col-sm-3 col-lg-3">
						<div class="widget">
							<h4>Information</h4>
							<ul class="link-list">
								<li><a href="#">Press release</a></li>
								<li><a href="#">Terms and conditions</a></li>
								<li><a href="#">Privacy policy</a></li>
								<li><a href="#">Career center</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</div>

					</div>
					<div class="col-sm-3 col-lg-3">
						<div class="widget">
							<h4>Pages</h4>
							<ul class="link-list">
								<li><a href="#">Press release</a></li>
								<li><a href="#">Terms and conditions</a></li>
								<li><a href="#">Privacy policy</a></li>
								<li><a href="#">Career center</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-lg-3">
						<div class="widget">
							<h4>Newsletter</h4>
							<p>Fill your email and sign up for monthly newsletter to keep
								updated</p>
							<div class="form-group multiple-form-group input-group">
								<input type="email" name="email" class="form-control"> <span
									class="input-group-btn">
									<button type="button" class="btn btn-theme btn-add">Subscribe</button>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="sub-footer">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="copyright">
								<p>
									<span>&copy; Sailor 2015 All right reserved. | Designed
										by </span><a href="http://bootstraptaste.com" target="_blank">BootstrapTaste</a>
									<!-- 
                                All links in the footer should remain intact. 
                                Licenseing information is available at: http://bootstraptaste.com/license/
                                You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Sailor
                            -->

								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<ul class="social-network">
								<li><a href="#" data-placement="top" title="Facebook"><i
										class="fa fa-facebook"></i></a></li>
								<li><a href="#" data-placement="top" title="Twitter"><i
										class="fa fa-twitter"></i></a></li>
								<li><a href="#" data-placement="top" title="Linkedin"><i
										class="fa fa-linkedin"></i></a></li>
								<li><a href="#" data-placement="top" title="Pinterest"><i
										class="fa fa-pinterest"></i></a></li>
								<li><a href="#" data-placement="top" title="Google plus"><i
										class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/modernizr.custom.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="plugins/flexslider/jquery.flexslider-min.js"></script>
	<script src="plugins/flexslider/flexslider.config.js"></script>
	<script src="js/jquery.appear.js"></script>
	<script src="js/stellar.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/uisearch.js"></script>
	<script src="js/jquery.cubeportfolio.min.js"></script>
	<script src="js/google-code-prettify/prettify.js"></script>
	<script src="js/animate.js"></script>
	<script src="js/custom.js"></script>


</body>
</html>