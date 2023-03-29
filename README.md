# Conventional Commit (Use in project)
- **fix**: A bug fix (using for code)
- **feat**: A new feature (using when add code of exercise)
- **refactor**: A code change that neither fixes a bug nor adds a feature (using for code)
- **docs**: Documentation only changes (use for readme, report)
# Conventional Java
- **Package names**:\
Package names use only lowercase letters and digits (no underscores). Consecutive words are simply concatenated together.\
For example, com.example.deepspace, not com.example.deepSpace or com.example.deep_space.
- **Class names**:\
Class names are written in UpperCamelCase.\
Class names are typically nouns or noun phrases. For example, Character or ImmutableList. 
- **Method names**:\
Method names are written in lowerCamelCase.\
Method names are typically verbs or verb phrases. For example, sendMessage or stop.
- **Constant names**:\
Constant names use UPPER_SNAKE_CASE: all uppercase letters, with each word separated from the next by a single underscore.
- **Non-constant field names**:\
Non-constant field names (static or otherwise) are written in lowerCamelCase.\
These names are typically nouns or noun phrases. For example, computedValues or index.
- **Parameter names**:\
Parameter names are written in lowerCamelCase.\
One-character parameter names in public methods should be avoided.
- **Local variable names**:\
Local variable names are written in lowerCamelCase.\
Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.
- **Type variable names**:\
A single capital letter, optionally followed by a single numeral (such as E, T, X, T2)\
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
- Viết câu lệnh tạo các bảng ( theo đúng naming convension mysql)\
Kho: Id, mã kho, tên, địa điểm, ngày tạo, ngày sửa\
Loại danh mục: Id, mã loại danh mục, tên, mô tả, ngày tạo, ngày sửa\
Sản phẩm: Id, mã sản phẩm, danh mục, kho, tên, mô tả sản phẩm, đường dẫn ảnh, số lượng sản phẩm, số lượng bán, giá, ngày tạo, ngày sửa
- Viết các câu lệnh
Tạo bảng, thêm, sửa, xóa, kho, sản phẩm, loại danh mục theo id\
Lọc các sản phẩm có chứa từ 'Điện Thoại' và thuộc loại danh mục có tên là 'Apple'\
Đếm số lượng sản phẩm trong mỗi loại danh mục, sắp xếp theo thứ tự giảm dần\
Xóa danh mục đồng thời xóa luôn các sản phẩm thuộc danh mục đó (Có sử dụng transaction)\
Procedure lấy 10 sản phẩm có số lượng bán nhiều nhất
# Ex4_Spring Boot Basic
- File báo cáo những kiến thức tìm hiểu được tight coupled, loosely coupled và dependency injection\
file cấu hình và Profiles
- Xem yêu cầu bài tại link sau:\
https://git.dktsoft.com:2008/training/spring-dependency-injection \
Yêu cầu thêm cấu hình theo profiles
# Ex5_DB_Springboot
Viết chương trình in ra dữ liệu của các bảng đã đã tạo ở trên (Ra console)
- 1 yêu cầu sql ở ex03 là 1 hàm xử lý riêng ở lớp service
- Sử dụng Data Access with JDBC để truy vấn đến CSDL
+ Sử dụng JdbcTemplate
+ NamedParameterJdbcTemplate
+ Sử dụng SimpleJdbc
- Sử dụng JPA để truy vấn đến CSDL
- Có xử lý exception, validate dữ liệu
- Xây dựng cấu trúc project tạo package theo tính năng, tách nhỏ phần xử lý ra nhiều file, nhiều hàm, có ghi chú giải thích xử lý ở từng hàm
# Ex6_Rest API
- Viết báo cáo thu hoạch về phần tìm hiểu Rest API: Các khái niệm, yêu cầu, quy tắc, quy chuẩn
- Dùng postman gọi các API ở link: https://petstore.swagger.io
   + Lưu 3 phần pet, store, user thành 3 collection tương ứng và export ra file json
# Ex7_Restful API_Spring
Viết các API về sản phẩm, danh mục. Yêu cầu có validate dữ liệu
- 1 yêu cầu sql ở ex03 là 1 api
- Api cơ bản sản phẩm
   + POST /admin/products : Thêm mới 1 sản phẩm
   + PUT /admin/products/{id} : Cập nhật một sản phẩm
   + GET /admin/products/{id} : Lấy thông tin 1 sản phẩm
   + GET /admin/products: Cho phép lọc sản phẩm theo tên, có phân trang (Theo 2 kiểu, mỗi trang tối đa 10 bản ghi)
- Làm tương tự tạo các API danh mục, kho\
Lưu ý API xoá danh mục sẽ xoá đồng thời xoá sản phẩm thuộc danh mục đấy ( Y/c sử dụng transaction)/
- go to: http://localhost:8080/swagger-ui.html