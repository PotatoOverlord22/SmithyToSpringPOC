$version: "2.0"

namespace com.uaic.smithypoc

@readonly
@http(method: "GET", uri: "/students")
operation GetStudents {
    input: GetStudentsInput
    output: GetStudentsOutput
    errors: [
        InvalidInputException
        InternalServerException
    ]
}

@input
structure GetStudentsInput {
}

@output
structure GetStudentsOutput {
    @required
    students: StudentList
}
