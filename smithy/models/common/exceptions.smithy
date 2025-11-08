$version: "2.0"

namespace com.uaic.smithypoc

@error("client")
@httpError(400)
structure InvalidInputException {
    message: String
}

@error("server")
@httpError(500)
structure InternalServerException {
    message: String
}