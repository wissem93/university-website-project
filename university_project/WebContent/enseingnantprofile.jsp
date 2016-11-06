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
								data-close-others="false">Actualités <i
									class="fa fa-angle-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="emplois.html">Emploi de Temps</a></li>
									<li><a href="addcomantaire">Forom</a></li>
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
							<li><a href="logoutservlet">Log out</a></li>

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
							<li><a href="#"><i class="fa fa-home"></i></a><i
								class="icon-angle-right"></i></li>
							<li><c:out value='${enseignant.nomuser}' /><i
								class="icon-angle-right"></i></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">
				<div class="row">




					<div class="col-lg-4">


						<div class="widget">
							<h5 class="widgetheading">A propos</h5>
							<ul class="cat">
								<li><i class="fa fa-angle-right"></i>
									<th>nom</th>
									<th><c:out value='${enseignant.nomuser}' /></th>
									</tr></li>
								<li><i class="fa fa-angle-right"></i>
									<th>prenom</th>
									<th><c:out value='${enseignant.prenom}' /></th>
									</tr></li>
								<li><i class="fa fa-angle-right"></i>
									<th>E-mail</th>
									<th><c:out value='${enseignant.email}' /></th>
									</tr></li>

								<li><i class="fa fa-angle-right"></i>
									<th>Telephone</th>
									<th><c:out value='${enseignant.telephone}' /></th>
									</tr></li>





								<li><i class="fa fa-angle-right"></i>
									<th>Filiere</th>
									<th><c:out value='${enseignant.gradeEnseignant}' /></th>
									</tr></li>

								</li>
							</ul>
						</div>
					</div>
















					<div class="col-lg-4">
						<h4>Example of paragraph</h4>
						<p>
							<strong>Lorem ipsum dolor sit amet</strong>, consetetur
							sadipscing elitr, sed diam non mod tempor invidunt ut labore et
							dolore magna aliquyam erat, sed diam voluptua.
						</p>
						<p class="lead">At vero eos et accusam et justo duo dolores et
							eabum.</p>
						<p>
							<em> Consetetur sadipscing elitr, sed diam non mod tempor
								invidunt ut labore et dolore magna aliquyam erat, sed diam
								voluptua. </em>
						</p>
						<p>
							<small> Consetetur sadipscing elitr, sed diam non mod
								tempor invidunt ut labore et dolore magna aliquyam erat, sed
								diam voluptua. </small>
						</p>
					</div>
					<div class="col-lg-4">
						<h4>Float image in paragraph</h4>
						<img src="img/dummies/dummy-1.jpg" alt=""
							class="img-responsive pull-left" />
						<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,</p>
						<div class="widget">
							<h5 class="widgetheading">Ajouter</h5>
							<ul class="tags">
								<li><a href="getalletudiantenseignant">Etudiant </a></li>
								<li><a href="addcour"> Cour </a></li>
								<li><a href="#"> Club </a></li>
								<li><a href="#">chager profile</a></li>
								<li><a href="addsujet">Sujet </a></li>

								<li><a href="AddNote">Note des etudiant </a></li>



							</ul>
						</div>
					</div>
				</div>
				<!-- divider -->
				<div class="row">
					<div class="col-lg-12">
						<div class="solidline"></div>
					</div>
				</div>
				<!-- end divider -->
				<!-- Descriptions -->
				<div class="row">
					<div class="col-lg-6">
						<!-- Description -->
						<h4>emplois de temps</h4>
						<dl>
							<dt>
								<c:out value="${emplois.nom }"></c:out>
							</dt>
							<dd>
								<c:out value="${emplois.description }"></c:out>
							</dd>
							<dt>
								<a href="www.google.com"> afficher </a>
							</dt>
							<dd>Vestibulum id ligula porta felis euismod semper eget
								lacinia odio sem nec elit.</dd>
							<dd>Donec id elit non mi porta gravida at eget metus.</dd>
							<dt>Malesuada porta</dt>
							<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
						</dl>
					</div>
					<!-- Horizontal Description -->
					<div class="col-lg-6"></div>
				</div>
				<!-- divider -->
				<div class="row">
					<div class="col-lg-12">
						<div class="solidline"></div>
					</div>
				</div>
				<!-- end divider -->
				<!-- Lists -->
				<div class="row">
					<!-- Unordered Lists -->
					<c:forEach items="${courses}" var="p">

						<div class="col-lg-3">
							<h4>${p.nomCours}</h4>




							<ul>
								<li>${p.nomCours}</li>
								<li>${p.nomCours}</li>
								<li><a href="http://${p.urlcours}">${p.urlcours}</a></li>
								<li>${p.urlcours}</li>
								<li>${p.descriptionCours}
									<ul>
										<li>${p.descriptionCours}</li>
										<li>${p.descriptionCours}</li>
									</ul>
								</li>
								<li>Faucibus porta lacus fringilla vel</li>
								<li>Aenean sit amet erat nunc</li>
								<li>Eget porttitor lorem</li>
							</ul>
						</div>
					</c:forEach>

					<!-- Unstyled Lists -->

					<div class="row">
						<div class="col-lg-12">
							<div class="solidline"></div>
						</div>
					</div>
					<!-- end divider -->
					<div class="row">


						<c:forEach items="${etudiants}" var="p">


							<div class="col-lg-4">

								<h4>${p.nomuser}</h4>
								<blockquote>
									<i class="icon-quote-left icon-2x"></i> Lorem ipsum dolor sit
									amet, consetetur sadipscing elitr, sed diam non mod tempor
									invidunt ut labore et dolore magna aliquyam erat, sed diam
									voluptua. <cite><a
										href="/university_project/infoetudiant?idetud=${p.iduser }">${p.nomuser}<br>${p.prenom}</a></cite>
								</blockquote>

							</div>
						</c:forEach>
					</div>
					<!-- divider -->
					<div class="row">
						<div class="col-lg-12">
							<div class="solidline"></div>
						</div>
					</div>
					<!-- end divider -->

				</div>
		</section>

		<footer>
			<div class="container">
				<div class="row">
					<c:forEach items="${clubs}" var="p">
						<div class="col-sm-3 col-lg-3">
							<div class="widget">
								<h4>Club</h4>
								<ul class="link-list">
									<li><a href="infoclub?idc=${p.idclub }">${p.nom }</a></li>
									<li><a href="#">${p.caractere}</a></li>
									<li><a href="#">Privacy policy</a></li>
									<li><a href="#">Career center</a></li>
									<li><a href="#">Contact us</a></li>
								</ul>
							</div>
						</div>
					</c:forEach>
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