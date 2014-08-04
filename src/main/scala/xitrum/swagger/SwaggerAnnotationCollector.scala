package swagger

object X {
  val TYPE_OF_SWAGGER = universe.typeOf[Swagger]

  def fromUniverse(annotations: Seq[universe.Annotation]): ActionAnnotations = {
    var ret = ActionAnnotations()

    annotations.foreach { a =>
      val tpe = a.tree.tpe

      if (tpe <:< TYPE_OF_SWAGGER)
        ret = ret.copy(swaggers = ret.swaggers :+ a)
    }

    ret
  }


  //  ActionAnnotations  swaggers:             Seq[universe.Annotation]    = Seq.empty[universe.Annotation]

}


/*
case class DiscoveredAcc(
  xitrumVersion:             String,
  normalRoutes:              SerializableRouteCollection,
  sockJsWithoutPrefixRoutes: SerializableRouteCollection,
  sockJsMap:                 Map[String, SockJsClassAndOptions],
  swaggerMap:                Map[Class[_ <: Action], Swagger]
)
*/

/*
    val newSwaggerMap = collectSwagger(annotations) match {
      case None          => acc.swaggerMap
      case Some(swagger) => acc.swaggerMap + (klass -> swagger)
    }
    DiscoveredAcc(acc.xitrumVersion, acc.normalRoutes, acc.sockJsWithoutPrefixRoutes, newSockJsMap, newSwaggerMap)
*/

/*
  private def collectSwagger(annotations: ActionAnnotations): Option[Swagger] = {
    val universeAnnotations = annotations.swaggers
    if (universeAnnotations.isEmpty) {
      None
    } else {
      var swaggerArgs = Seq.empty[SwaggerArg]
      universeAnnotations.foreach { annotation =>
        annotation.tree.children.tail.foreach { scalaArg =>
          // Ex:
          // List(xitrum.annotation.Swagger.Response.apply, 200, "ID of the newly created article will be returned")
          // List(xitrum.annotation.Swagger.StringForm.apply, "title", xitrum.annotation.Swagger.StringForm.apply$default$2)
          // List(xitrum.annotation.Swagger.StringForm.apply, "title", "desc")
          val children = scalaArg.children

          val child0 = children(0).toString
          if (child0 == "xitrum.annotation.Swagger.Summary.apply") {
            val summary = children(1).productElement(0).asInstanceOf[universe.Constant].value.toString
            swaggerArgs = swaggerArgs :+ Swagger.Summary(summary)
          } else if (child0 == "xitrum.annotation.Swagger.Note.apply") {
            val note = children(1).productElement(0).asInstanceOf[universe.Constant].value.toString
            swaggerArgs = swaggerArgs :+ Swagger.Note(note)
          } else if (child0 == "xitrum.annotation.Swagger.Response.apply") {
            val code = children(1).toString.toInt
            val desc = children(2).productElement(0).asInstanceOf[universe.Constant].value.toString
            swaggerArgs = swaggerArgs :+ Swagger.Response(code, desc)
          } else {  // param or optional param
            val name = children(1).productElement(0).asInstanceOf[universe.Constant].value.toString

            val desc =
              if (children(2).toString.startsWith("xitrum.annotation.Swagger"))
                ""
              else
                children(2).productElement(0).asInstanceOf[universe.Constant].value.toString

            // Use reflection to create annotation

            // Ex: xitrum.annotation.Swagger.StringForm.apply
            val scalaClassName = child0.substring(0, child0.length - ".apply".length)

            val builder = new StringBuilder(scalaClassName)
            builder.setCharAt("xitrum.annotation.Swagger".length, '$')

            // Ex: xitrum.annotation.Swagger$StringForm
            val cl            = Thread.currentThread.getContextClassLoader
            val javaClassName = builder.toString
            val klass         = cl.loadClass(javaClassName)
            val constructor   = klass.getConstructor(classOf[String], classOf[String])
            swaggerArgs = swaggerArgs :+ constructor.newInstance(name, desc).asInstanceOf[SwaggerArg]
          }
        }
      }

      Some(Swagger(swaggerArgs: _*))
    }
  }
*/


/*
object RouteCollection {
  def fromSerializable(acc: DiscoveredAcc, withSwagger: Boolean): RouteCollection = {
    val normal              = acc.normalRoutes
    val sockJsWithoutPrefix = acc.sockJsWithoutPrefixRoutes
    val sockJsMap           = acc.sockJsMap

    val swaggerMap: Map[Class[_ <: Action], Swagger] = if (withSwagger) acc.swaggerMap else Map.empty
*/

/*
  val swaggerMap:     Map[Class[_ <: Action], Swagger],
*/


/*
    if (!Config.productionMode) {
      Config.routes    = Config.loadRoutes(true)
      SwaggerJson.apis = SwaggerJson.loadApis()
    }
*/

/*
val withSwagger = xitrum.swaggerApiVersion.isDefined
        RouteCollection.fromSerializable(discoveredAcc, withSwagger)
*/

/*
  val swaggerApiVersion = if (config.hasPath("swaggerApiVersion")) Some(config.getString("swaggerApiVersion")) else None
*/