# OOP Lab 01 – 03 (AIMS Project)

Cấu trúc theo yêu cầu cuối của Lab03 (mục 8):

```
AimsProject/
  src/hust/soict/dsai/aims/Aims.java
  src/hust/soict/dsai/aims/disc/DigitalVideoDisc.java
  src/hust/soict/dsai/aims/cart/Cart.java
  src/hust/soict/dsai/aims/store/Store.java
  src/hust/soict/dsai/test/cart/CartTest.java
  src/hust/soict/dsai/test/store/StoreTest.java
  src/hust/soict/dsai/test/disc/TestPassingParameter.java
  Design/       class.png  (+ class.puml – nguồn)
  Requirement/  usecase.png (+ usecase.puml – nguồn)
OtherProjects/
  src/hust/soict/dsai/lab01/   (toàn bộ bài Lab01)
  src/hust/soict/dsai/garbage/ (ConcatenationInLoops, GarbageCreator, NoGarbage)
ReadingAssignment/ mindmap.png
answers.txt
```

## Bản đồ bài tập
| Đề | File |
|---|---|
| Lab01 2.2.1–2.2.4 | HelloWorld, FirstDialog, HelloNameDialog, ShowTwoNumbers |
| Lab01 2.2.5 | Calculator |
| Lab01 2.2.6 | EquationSolver |
| Lab01 6.1–6.6 | ChoosingOption, InputFromKeyboard, StarTriangle, DaysOfMonth, ArraySortSum, MatrixAddition |
| Lab02 5–11 | Aims, DigitalVideoDisc, Cart |
| Lab03 2 (overloading) | Cart.addDigitalVideoDisc(...) ×3 |
| Lab03 3–4 | TestPassingParameter |
| Lab03 5 | id + nbDigitalVideoDiscs trong DigitalVideoDisc |
| Lab03 6 | Cart.print / searchById / searchByTitle, CartTest |
| Lab03 7 | Store, StoreTest |
| Lab03 9 | garbage package |

## Việc phải tự làm
1. **File .astah**: đề yêu cầu nộp cả `usecase.asta` và `class.asta`. Mở Astah, vẽ lại theo `usecase.png` / `class.png`, lưu vào đúng thư mục.
2. **Eclipse**: File → Import → Existing Projects into Workspace → chọn thư mục repo (nhận cả 2 project).
3. **GarbageCreator**: chạy với tham số là 1 file lớn (Run Configurations → Arguments), chụp màn hình khi chạy chậm.
4. **Debug (Lab03 mục 4)**: thao tác breakpoint trong Eclipse, chụp màn hình nếu GV yêu cầu.
5. **Git + Release Flow**: repo đã có sẵn lịch sử các nhánh; xem lệnh push trong phần dưới.

## Đẩy lên GitHub
```bash
git remote add origin https://github.com/<user>/<repo>.git
git push origin --all
```
