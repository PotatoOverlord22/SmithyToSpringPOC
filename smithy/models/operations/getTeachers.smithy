$version: "2.0"

namespace com.uaic.smithypoc

@readonly
@http(method: "GET", uri: "/teachers")
@tags(["teachers"])
operation GetTeachers {
    input: GetTeachersInput
    output: GetTeachersOutput
    errors: [
        InvalidInputException
        InternalServerException
    ]
}

@input
structure GetTeachersInput {
}

@output
structure GetTeachersOutput {
    @required
    teachers: TeacherList
}
