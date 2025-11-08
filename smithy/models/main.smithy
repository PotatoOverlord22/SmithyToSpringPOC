$version: "2.0"

namespace com.uaic.smithypoc

use aws.protocols#restJson1

@title("SmithyPOC")
@restJson1
service SmithyPOC {
    version: "2025-11-08"
    operations: [
        GetStudents
    ]
}
