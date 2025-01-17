Nguyen Anh Ngoc


8/1/2025
	Collection APi

-Java core (string book
-OOP (Lt Hướng đt)
+ kế thừa[dùng lại code, kt toàn phần]
+ che đậy hành vi (đóng gói):
	 protceted (giới hạn trong 1 packet][khi là con thi vẫn có thể gọi)
	 public (ko giới hạn)
	 privte (bảo mật cao nhất ko cho bên ngoài gọi )
+ abstraction{data abstraction}( trừu tượng hóa{Tt hóa dữ liệu}) xác định hành vi và đối tượng (đơn giản hóa và lược bớt chi tiết ko liên quan)
 [khác với abtract class]
 
+ da 

- object tạo(đối tượng)  ra class
- OOAD ( phân tich thiết kế hướng đối tượng) 1 trong những cơ sở hàng đầu 
từ con tạo cha đặc (điểm chung của các lớp con)


Intrface 1 rổ hành vi khác nhau
-Sự khác nhau giữa interface và abstract class
Tất cả phương thức trong interface luôn luôn(được hiểu) là abstract.
Các phương thức trong abstract class là abstract hoặc không phải là abstract.
Có thể implements nhiều interface nhưng không thể extends trực tiếp nhiều class.
Các phương thức trong interface luôn luôn phải để là public, khác với abstract class có thể là public hoặc protected.
-Sự giống nhau giữa interface và abstract class
Không thể tạo một biến kiểu interface hoặc abstract class.
Nếu là phương thức abstract thì phải được khai báo lại trong class con.
Cả interface và abstract class đều có tính kế thừa.
-Khi nào thì sử dụng interface, khi nào sử dụng abstract class
+Khi một nhóm đối tượng có cùng bản chất kế thừa từ một class thì sử dụng abstract class.
+Khi một nhóm đối tượng không có cùng bản chất nhưng chúng có hành động giống nhau thì sử dụng interface.

-  Collection APi 
-Java Virtual Machine(JVM) ‘Viết một lần, chạy ở mọi nơi" (Write Once, Run Anywhere), JRE (java running environment)  
OS( hệ điêu hành)
+ *.java -biên dịch> *.class -thông dịch>  application


I. list Interface 
list interface: là interface của collection interface 
ta có thể lưu trữ các tập hợp các đối tượng có thứ tự

-list: là 1 danh sách các phần tử có thứ tự. list có thể có nhiều phần giống nhau  (có thứ tự đc trùng) 
+array: sắp xếp liên tục (truy cập nhanh nhưng thêm sửa xoá chậm) (ko dùng cho create và edit), ưu tiên dùng cho việc đọc (view)
+Linked: liên kết đậm (thêm sửa xoá nhanh nhưng truy cập chậm)  dùng trong dữ liệu biến động
+stack:  lưu các phần tử theo công thức LIFO( Last In FIsrt Out)
-set: là 1 danh sách chứa các phần tử ko có thứ  tự và ko cho phép trùng nhau (ko thứ tự đc ko đc trùng)
+
-map: lưu trữ các phần tử theo cặp giá trị (key, Value) ko cho phép trùng nhau 
-queue: lưu các phần tử theo công thức FIFO( Fisrt In FIsrt Out)

quan trọng (OOP. collection. bảo mật cơ bản)
1 bài toán có linkedList ArrayList
mỗi class 1 bài toán thêm sửa xoá 1 danh sách dưới dạng menu

10/1/2025

MVC DESIGN PATTERN



Model (Mô hình):
Định nghĩa: Đại diện cho dữ liệu hoặc logic nghiệp vụ của ứng dụng.
Trách nhiệm: Quản lý dữ liệu, logic và các quy tắc của ứng dụng. Nó sẽ cập nhật giao diện người dùng (view) khi có thay đổi về dữ liệu và thông báo cho controller nếu cần thiết.
Ví dụ: Một lớp quản lý dữ liệu người dùng, như truy xuất thông tin từ cơ sở dữ liệu hoặc thực hiện các phép tính.
View (Giao diện người dùng):
Định nghĩa: Đại diện cho giao diện người dùng của ứng dụng.
Trách nhiệm: Hiển thị dữ liệu từ Model cho người dùng và chuyển các sự kiện từ người dùng (như nhấp chuột, nhập liệu) đến Controller.
Ví dụ: Các mẫu HTML, các phần tử giao diện người dùng hoặc bất kỳ dạng giao diện nào mà người dùng tương tác.
Controller (Điều khiển):
Định nghĩa: Là cầu nối giữa Model và View.
Trách nhiệm: Nhận đầu vào từ View, xử lý chúng (thường là cập nhật Model) và cập nhật lại View. Nó kết nối các hành động của người dùng với logic của ứng dụng.
Ví dụ: Một lớp Controller xử lý các sự kiện như nhấp nút hoặc gửi biểu mẫu.
Quá trình hoạt động:
Người dùng tương tác với View (ví dụ: nhấn nút hoặc gửi biểu mẫu).
View gửi đầu vào của người dùng đến Controller.
Controller xử lý đầu vào, có thể cập nhật Model.
Model cập nhật trạng thái và có thể trả dữ liệu lại cho Controller.
Controller cập nhật View để phản ánh các thay đổi, cung cấp phản hồi cho người dùng.

	ATM

giả sử viết 1 trương trinh thực thi ATM system hoặc giao dịch trực tuyết ( internet banking) sẽ phải sử dụng các collection API ntn? 
1. Map<string, Account> accountMap = new Hashmap<>();
 -chức năng: lưu trữ danh sách tài khoản dể tra cứu nhanh theo stk (accountNumber)
 	-HashMap: có thời gian truy xuất phần tử trung bình là o(1) phù hợp cho thao tác tìm kiếm cập nhật.
[ O(1) là một trong những trường hợp tốt nhất của độ phức tạp thuật toán vì nó đảm bảo hiệu suất ổn định bất kể kích thước đầu vào.]

2.List<Transaction> transactionList = new ArayList<>();
	-chức năng: lưu toàn bộ ls giao dịch
	-ArrayList: cho phép duyệt và thêm cuối nhanh tb là o(1). ko dùng cho thao tác chèn xoá sửa ở giữa bản ghi thường xuyên

3. Set<String> blackListAccount = HashSet<>();
	-chức năng: lưu danh sách bị khoá, (blackList), cần ko trùng lặp và kiểm tra thành viên nhanh (tìm kiếm nhanh)
	-HashSet: cho phép kiểm tra nhanh tb o(1), rất thích hợp tìm kiếm, ngăn chặn
4.Queue<Transtraction> transtactionQueue = new LinkedList<>():
-chức năng: minh hoạ mô hình FIFO(FIsrt In First Out) cho phép giao dịch diễn ra lần lượt.
-LinkList thực hiện tốt cấu trúc queue. 
5.Set<String> storedAccountNumber = new Tree<>();
-chức năng: Lưu các accoutNumber dưới dạng sắp xếp ko tự nhiên (theo thứ tự tăng dần) ko trùng
6.PriorityQueue<Account> accountByBalance = new PriorityQueue<>(Comparator);
	-chức năng: Lưu account theo độ ưu tiên (vd: sắp xếp giảm dân theo số dư), giúp ta biết ngay tài khoản có số dư lớn nhất…
	-PriorityOueue cho phép lấy phần tử có dộ ưu tiên cao nhất trong o(log n)

viết hiểu áp dụng phân tích 
