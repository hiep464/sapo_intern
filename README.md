# Conventional Commit (Use in project)
- fix: A bug fix (using for code)
- feat: A new feature (using when add code code of exercise)
- refactor: A code change that neither fixes a bug nor adds a feature (using for code)
- docs: Documentation only changes (use for readme, report)
# Conventional Java
- Package names:
Package names use only lowercase letters and digits (no underscores). Consecutive words are simply concatenated together.
For example, com.example.deepspace, not com.example.deepSpace or com.example.deep_space.
- Class names:
Class names are written in UpperCamelCase.
Class names are typically nouns or noun phrases. For example, Character or ImmutableList. 
- Method names:
Method names are written in lowerCamelCase.
Method names are typically verbs or verb phrases. For example, sendMessage or stop.
- Constant names:
Constant names use UPPER_SNAKE_CASE: all uppercase letters, with each word separated from the next by a single underscore.
- Non-constant field names:
Non-constant field names (static or otherwise) are written in lowerCamelCase.
These names are typically nouns or noun phrases. For example, computedValues or index.
- Parameter names:
Parameter names are written in lowerCamelCase.
One-character parameter names in public methods should be avoided.
- Local variable names:
Local variable names are written in lowerCamelCase.
Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.
- Type variable names:
A single capital letter, optionally followed by a single numeral (such as E, T, X, T2)
A name in the form used for classes (see Section 5.2.2, Class names), followed by the capital letter T (examples: RequestT, FooBarT).

# Ex1_Framework: Báo cáo thu hoạch:
- Framework là gì
- Spring framework là gì, có tác dụng gì
- Ngoài Spring thì Java còn có các framework nào khác
# Ex2_Maven_Spring boot:
- Clone https://git.dktsoft.com:2008/training/spring-boot-hello-world
- Add thư viện: https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
- Thực thi các method: "containsAny", "containsIgnoreCase","countMatches","appendIfMissing", "prependIfMissing","uppercase", "lowercase" ( dữ liệu được lấy từ console do người dùng nhập)
- Dùng maven package lại thành 1 file thực thi .jar
# Ex03_Mysql
- File báo cáo những kiến thức tìm hiểu được Sql, no sql, join, function, procedure, transaction, index,...
- Viết câu lệnh tạo các bảng ( theo đúng naming convension mysql)
Kho: Id, mã kho, tên, địa điểm, ngày tạo, ngày sửa
Loại danh mục: Id, mã loại danh mục, tên, mô tả, ngày tạo, ngày sửa
Sản phẩm: Id, mã sản phẩm, danh mục, kho, tên, mô tả sản phẩm, đường dẫn ảnh, số lượng sản phẩm, số lượng bán, giá, ngày tạo, ngày sửa
- Viết các câu lệnh
Tạo bảng, thêm, sửa, xóa, kho, sản phẩm, loại danh mục theo id
Lọc các sản phẩm có chứa từ 'Điện Thoại' và thuộc loại danh mục có tên là 'Apple'
Đếm số lượng sản phẩm trong mỗi loại danh mục, sắp xếp theo thứ tự giảm dần
Xóa danh mục đồng thời xóa luôn các sản phẩm thuộc danh mục đó (Có sử dụng transaction)
Procedure lấy 10 sản phẩm có số lượng bán nhiều nhất
# Ex4_Spring Boot Basic
- File báo cáo những kiến thức tìm hiểu được tight coupled, loosely coupled và dependency injection
file cấu hình và Profiles
- Xem yêu cầu bài tại link sau:
https://git.dktsoft.com:2008/training/spring-dependency-injection
Yêu cầu thêm cấu hình theo profiles