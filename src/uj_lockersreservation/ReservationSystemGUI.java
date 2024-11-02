
package uj_lockersreservation;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ReservationSystemGUI extends JFrame {

    public ReservationSystemGUI() { 
        super("UJ Lockers Reservation");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //page1();
        //page2();
       //page3();
       //page4();
       //page5();
       page6();

        
    }

    // الصفحة الأولى: تسجيل الدخول
    public void page1() {
        // تغيير التخطيط ليكون BorderLayout للواجهة الرئيسية
        setLayout(new BorderLayout());

        // لوحة تسجيل الدخول
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout()); // مركز العناصر
        loginPanel.setBackground(new Color(245, 245, 245)); // خلفية خفيفة للوحة
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // مسافة بين العناصر
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // رسالة الترحيب الرئيسية
        JLabel welcomeLabel = new JLabel("Welcome to UJ Lockers Reservation System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 102, 204)); // لون أزرق جذاب
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(welcomeLabel, gbc);

        // أيقونة ترحيب (إضافة أيقونة لطيفة في الأعلى)
        JLabel iconLabel = new JLabel(new ImageIcon("icon.png")); // تحتاج إلى صورة باسم icon.png في المجلد
        gbc.gridy++;
        loginPanel.add(iconLabel, gbc);


        // زر تسجيل الدخول
        JButton loginButton = new JButton("Log in");
        styleButton(loginButton);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        // زر التسجيل
        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        gbc.gridy++;
        loginPanel.add(registerButton, gbc);

        add(loginPanel, BorderLayout.CENTER);
        
        // عرض الواجهة
        setVisible(true);
    }

// الصفحة الثانية: واجهة التسجيل
    public void page2() {
        // تفريغ محتويات الإطار الحالي
        getContentPane().removeAll();

        // إعداد تخطيط الواجهة
        setLayout(new BorderLayout());

        // إنشاء واجهة التسجيل
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        registerPanel.setBackground(new Color(245, 245, 245)); // خلفية خفيفة للوحة
        GridBagConstraints gbc = new GridBagConstraints();

        // إعداد الهوامش وتنسيق التخطيط
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // عنوان واجهة التسجيل
        JLabel signUpLabel = new JLabel("Create a New Account", SwingConstants.CENTER);
        signUpLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        signUpLabel.setForeground(new Color(0, 102, 204)); // لون أزرق جذاب
        gbc.gridwidth = 2; // توسعة العنوان ليمتد على كامل العرض
        registerPanel.add(signUpLabel, gbc);

        // حقل الاسم الأول
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        JTextField firstNameField = new JTextField(15);
        firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        registerPanel.add(firstNameField, gbc);

        // حقل اسم العائلة
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        JTextField lastNameField = new JTextField(15);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        registerPanel.add(lastNameField, gbc);

        // حقل البريد الإلكتروني
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(15);
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        registerPanel.add(emailField, gbc);
        
        // حقل الرقم الجامعي
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("ID Number:");
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(15);
        idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        registerPanel.add(idField, gbc);

        // حقل كلمة المرور
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        registerPanel.add(passwordField, gbc);

        // زر التسجيل
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton signUpSubmitButton = new JButton("Register");
        styleButton(signUpSubmitButton);
        registerPanel.add(signUpSubmitButton, gbc);

        // زر للرجوع إلى صفحة تسجيل الدخول
        gbc.gridy++;
        JButton backButton = new JButton("Back");
        styleButton(backButton);
        backButton.setBackground(new Color(233, 87, 63)); // لون أحمر لزر الرجوع
        registerPanel.add(backButton, gbc);

        // إضافة واجهة التسجيل إلى الإطار
        add(registerPanel, BorderLayout.CENTER);

    }

        // الصفحة الثالثة: واجهة تسجيل الدخول
    public void page3() {

        setLayout(new BorderLayout());

        // إنشاء واجهة تسجيل الدخول
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(new Color(245, 245, 245)); // خلفية خفيفة للوحة
        GridBagConstraints gbc = new GridBagConstraints();

        // إعداد الهوامش وتنسيق التخطيط
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // عنوان واجهة تسجيل الدخول
        JLabel loginLabel = new JLabel("Log in", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        loginLabel.setForeground(new Color(0, 102, 204)); // لون أزرق جذاب
        gbc.gridwidth = 2; // توسعة العنوان ليمتد على كامل العرض
        loginPanel.add(loginLabel, gbc);

        // حقل الرقم الجامعي
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel idLabel = new JLabel("ID Number:");
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        loginPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(15);
        idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loginPanel.add(idField, gbc);

        // حقل الاسم الأول
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        loginPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        JTextField firstNameField = new JTextField(15);
        firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loginPanel.add(firstNameField, gbc);

        // زر تسجيل الدخول
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        styleButton(loginButton);
        loginPanel.add(loginButton, gbc);

        // إضافة واجهة تسجيل الدخول إلى الإطار
        add(loginPanel, BorderLayout.CENTER);

    }
    
public void page4() {
    // تفريغ محتويات الإطار الحالي
    getContentPane().removeAll();

    // إعداد التخطيط الرئيسي للإطار
    setLayout(new BorderLayout(10, 10));

    // إنشاء العنوان
    JLabel questionLabel = new JLabel("Which building do you want?", SwingConstants.CENTER);
    questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    questionLabel.setForeground(new Color(0, 102, 204)); // لون أزرق جذاب للعناوين
    add(questionLabel, BorderLayout.NORTH);

    // إنشاء اللوحة الخاصة بخيارات المباني
    JPanel buildingPanel = new JPanel();
    buildingPanel.setLayout(new GridLayout(0, 2, 15, 15)); // تخطيط الشبكة مع عمودين وتباعد مناسب
    buildingPanel.setBackground(new Color(245, 245, 245)); // لون خلفية خفيف لإبراز الصناديق

    // مصفوفة أرقام المباني المتاحة
    String[] buildingNumbers = {
        "Building 11", "Building 17", "Building 5", "Building 12",
        "Building 3", "Building 14", "Building 6", "Building 7",
        "Building 8", "Building 15", "Building 2", "Building 9",
        "Building 10", "Building 4", "Building 18", "Building 20"
    };

    // إعداد تصميم صناديق المباني وإضافتها إلى اللوحة
    for (String building : buildingNumbers) {
        JPanel buildingBox = new JPanel(new BorderLayout());
        buildingBox.setBackground(new Color(220, 220, 220)); // لون خلفية خفيف لكل صندوق
        buildingBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 153, 204), 2), // إطار بلون أحمر خفيف
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // نص لعرض رقم المبنى
        JLabel buildingLabel = new JLabel(building, SwingConstants.CENTER);
        buildingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        buildingLabel.setForeground(new Color(50, 50, 50)); // لون رمادي غامق للنص
        buildingBox.add(buildingLabel, BorderLayout.CENTER);

        // إضافة الصندوق إلى لوحة المباني
        buildingPanel.add(buildingBox);
    }

    // إضافة اللوحة إلى شريط تمرير لتسهيل التمرير
    JScrollPane scrollPane = new JScrollPane(buildingPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // إضافة اللوحة الرئيسية إلى الإطار
    add(scrollPane, BorderLayout.CENTER);


}

    public void page5() {
        // تفريغ محتويات الإطار الحالي
        getContentPane().removeAll();

        // إعداد التخطيط الرئيسي للإطار
        setLayout(new BorderLayout(10, 10));

        // إنشاء عنوان الصفحة مع اسم المبنى
        JLabel buildingLabel = new JLabel("Building A - Locker Availability", SwingConstants.CENTER);
        buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        buildingLabel.setForeground(new Color(0, 102, 204)); // لون أزرق جذاب للعناوين
        add(buildingLabel, BorderLayout.NORTH);

        // لوحة الخزانات
        JPanel lockerPanel = new JPanel();
        lockerPanel.setLayout(new GridLayout(0, 5, 15, 15)); // 5 أعمدة وتباعد 15 بين الصناديق
        lockerPanel.setBackground(new Color(245, 245, 245)); // خلفية خفيفة للوحة

        // قائمة الخزانات المتاحة وغير المتاحة
        String[] availableLockers = {
            "Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5",
            "Locker 6", "Locker 7", "Locker 8", "Locker 9", "Locker 10",
            "Locker 11", "Locker 12", "Locker 13", "Locker 14", "Locker 15",
            "Locker 16", "Locker 17", "Locker 18", "Locker 19", "Locker 20",
            "Locker 21", "Locker 22", "Locker 23", "Locker 24", "Locker 25"
        };

        String[] unavailableLockers = {
            "Locker 26", "Locker 27", "Locker 28", "Locker 29", "Locker 30",
            "Locker 31", "Locker 32", "Locker 33", "Locker 34", "Locker 35",
            "Locker 36", "Locker 37", "Locker 38", "Locker 39", "Locker 40",
            "Locker 41", "Locker 42", "Locker 43", "Locker 44", "Locker 45",
            "Locker 46", "Locker 47", "Locker 48", "Locker 49", "Locker 50"
        };

        // إعداد صناديق الخزانات المتاحة (باللون الأخضر)
        for (String locker : availableLockers) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(46, 204, 113)); // لون أخضر مميز
            panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 2), // إطار أخضر داكن
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            JLabel lockerLabel = new JLabel(locker, SwingConstants.CENTER);
            lockerLabel.setFont(new Font("Arial", Font.BOLD, 14));
            lockerLabel.setForeground(Color.WHITE); // لون النص أبيض
            panel.add(lockerLabel, BorderLayout.CENTER);

            lockerPanel.add(panel); // إضافة الصندوق إلى لوحة الخزانات
        }

        // إعداد صناديق الخزانات غير المتاحة (باللون الأحمر)
        for (String locker : unavailableLockers) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(231, 76, 60)); // لون أحمر للخزانات غير المتاحة
            panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(192, 57, 43), 2), // إطار أحمر داكن
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));

            JLabel lockerLabel = new JLabel(locker, SwingConstants.CENTER);
            lockerLabel.setFont(new Font("Arial", Font.BOLD, 14));
            lockerLabel.setForeground(Color.WHITE); // لون النص أبيض
            panel.add(lockerLabel, BorderLayout.CENTER);

            lockerPanel.add(panel); // إضافة الصندوق إلى لوحة الخزانات
        }

        // إضافة لوحة الخزانات إلى شريط تمرير للتمرير العمودي
        JScrollPane scrollPane = new JScrollPane(lockerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER); // إضافة شريط التمرير إلى الإطار

}
    private void styleButton(JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204)); // لون أزرق فاتح
        button.setForeground(Color.WHITE); // لون النص أبيض
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // حواف أكبر
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // مؤشر اليد عند المرور
        button.setOpaque(true);
    }
    public void page6() {
    // تفريغ محتويات الإطار الحالي
    //getContentPane().removeAll();

    // إعداد اللوحات
    JPanel panel0 = new JPanel(new GridLayout(4, 0, 10, 10));
    JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10)); // لأزرار الفصل
    JPanel panel2 = new JPanel(new GridLayout(2, 2, 10, 10)); // لأزرار الدفع
    JPanel panel3 = new JPanel(new BorderLayout()); //
    JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // لأزرار الفصل
    JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // حقل المبلغ
    JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // رمز العملة
    JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // نص "Payment" والأيقونة
    JPanel panel15 = new JPanel(new BorderLayout()); //payment , الازرار


    // تنسيق الأزرار لفصلي الدراسة
    JButton semester1Button = new JButton("Semester 1");
    JButton semester2Button = new JButton("Semester 2");
    styleButton(semester1Button);
    styleButton(semester2Button);
    panel.add(semester1Button);
    panel.add(semester2Button);
    panel4.add(panel); // إضافة أزرار الفصل إلى panel4
    panel4.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10)); // هوامش لأزرار الفصل

    // حقل العملة والمبلغ
    JLabel rs = new JLabel("RS");
    rs.setFont(new Font("Times New Roman", Font.BOLD, 16));
    JTextField amount = new JTextField(15);
    amount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // خط أسفل الحقل
    panel7.add(rs);
    panel7.add(amount);
    panel6.add(panel7);

    // أيقونة ونص "Payment"
    ImageIcon originalIcon = new ImageIcon("C:\\Users\\s4ooo\\Downloads\\UJ_LockersReservation-main\\UJ_LockersReservation-main\\UJ_LockersReservation\\src\\uj_lockersreservation\\download.png");
    Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // تغيير الحجم
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    JLabel ico = new JLabel(scaledIcon);
    JLabel payment = new JLabel("Payment");
    payment.setFont(new Font("Times New Roman", Font.BOLD, 18));
    payment.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // هوامش للنص
    panel8.add(ico);
    panel8.add(payment);

    // أزرار خيارات الدفع
    JButton visa = new JButton("Visa");
    JButton mada = new JButton("Mada");
    JButton tamara = new JButton("Tamara");
    JButton pay = new JButton("Pay");
    styleButton(visa);
    styleButton(mada);
    styleButton(tamara);
    styleButton(pay);
    panel2.add(visa);
    panel2.add(mada);
    panel2.add(tamara);
    panel2.add(pay);
    
    panel15.add(panel8,BorderLayout.NORTH);
    panel15.add(panel2);
    

    
    // زر "الدفع عند الاستلام"
    JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton cashOnDeliveryButton = new JButton("Cash on Delivery");
    styleButton(cashOnDeliveryButton);
    cashOnDeliveryButton.setBackground(new Color(233, 87, 63)); // لون أحمر فاتح لزر الدفع عند الاستلام
    panel5.add(cashOnDeliveryButton);
    panel5.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10)); // هوامش

    // إضافة اللوحات الرئيسية
    panel0.add(panel4);    // لوحة أزرار الفصول
    panel0.add(panel6);    // حقل العملة والمبلغ
    //panel0.add(panel8);    // أيقونة ونص "Payment"
    panel0.add(panel15);
    //panel0.add(panel2);    // لوحة خيارات الدفع
    panel0.add(panel5);    // زر "الدفع عند الاستلام"

    // إعداد الإطار الرئيسي
    panel0.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // حواف للوحة الرئيسية
    add(panel0, BorderLayout.CENTER);

    // إعادة رسم الواجهة
    revalidate();
    repaint();
}
}
    
//        public void page6() {
//            
//        setTitle("Payment Interface");
//        JPanel panel0 = new JPanel();
//        JPanel panel = new JPanel();
//        JPanel panel2 = new JPanel();
//        JPanel panel3 = new JPanel();
//        JPanel panel4 = new JPanel();
//        JPanel panel5 = new JPanel();   
//        JPanel panel6 = new JPanel();   
//        JPanel panel7 = new JPanel();
//        JPanel panel8 = new JPanel();
//
//
//
//    /*
//        panel.setLayout(new GridLayout(1,2,5,5));
//        panel4.setLayout(new BorderLayout());
//        JButton semester1Button = new JButton("Semester 1");
//        JButton semester2Button = new JButton("Semester 2");
//        panel.add(semester1Button);
//        panel.add(semester2Button );
//        panel4.add(panel,BorderLayout.EAST);
//        
//        
//       panel4.setBorder(BorderFactory.createEmptyBorder(25,25,10,10)); // مسافة
//
//*/
//               panel.setLayout(new GridLayout(1,2,5,5));
////        panel4.setLayout(new BorderLayout());
//        JButton semester1Button = new JButton("Semester 1");
//        JButton semester2Button = new JButton("Semester 2");
//        panel.add(semester1Button);
//        panel.add(semester2Button );
//        panel4.add(panel);
//        
//        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT)); // ضبط التخطيط لليسار
//
//        
//       panel4.setBorder(BorderFactory.createEmptyBorder(25,25,10,10)); // مسافة
//
//       
//        
//
//            
//        JLabel rs = new JLabel("rs");
//        JTextField amount= new JTextField(25);
////        panel6.add(rs);
////        panel6.add(amount);
//        
//        amount.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK)); // خط أسود في الأسفل
//
//        panel7.setLayout(new FlowLayout(FlowLayout.LEFT)); // ضبط التخطيط لليسار
//
//        panel7.add(rs);
//        panel7.add(amount);
//        panel6.setLayout(new FlowLayout(FlowLayout.LEFT)); // ضبط التخطيط لليسار
//
//                panel6.add(panel7);
//
//    
//         // إنشاء أيقونة
////        ImageIcon icon = new ImageIcon(getClass().getResource("/uj_lockersreservation/download.jpg"));
//        ImageIcon originalIcon = new ImageIcon("C:\\NetBeansProjects\\UJ_LockersReservation\\src\\uj_lockersreservation\\download.png");
//        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // تغيير الحجم
//        ImageIcon scaledIcon = new ImageIcon(scaledImage); // إنشاء ImageIcon جديد بالحجم المصغر
//        JLabel ico = new JLabel(scaledIcon); // إنشاء JLabel للأيقونة
//
////, SwingConstants.LEFT
//        JLabel payment = new JLabel("Payment");
//        payment.setBorder(BorderFactory.createEmptyBorder(10,0,0,10)); // مسافة
//
//        panel8.add(ico); // إضافة الأيقونة
//        panel8.add(payment);
//        panel8.setLayout(new FlowLayout(FlowLayout.LEFT)); // ضبط التخطيط لليسار
//        
////t-l-b-r
//
//        JButton Mada = new JButton("Mada");
//        JButton visa = new JButton("Visa");
//        JButton pay = new JButton("Pay");
//        JButton Tamara = new JButton("Tamara");
//
// 
//        
//        panel2.setLayout(new GridLayout(2,2,10,10));
//
//        panel2.add(visa);
//        panel2.add(Mada);
//        panel2.add(Tamara);
//        panel2.add(pay);
//     
////        panel3.setLayout(new BorderLayout());
//        panel3.add(panel2);
//
//        panel3.setLayout(new FlowLayout(FlowLayout.LEFT)); // ضبط التخطيط لليسار
//
////        panel3.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 150)); //t-l-b-r
//
//        
//        JButton cashOnDeliveryButton = new JButton("Cash on Delivery");
////        panel5.setLayout(new BorderLayout());
//        panel5.add(cashOnDeliveryButton);
////        
//       
//       panel5.setLayout(new FlowLayout(FlowLayout.RIGHT)); // ضبط التخطيط لليسار
//       panel5.setBorder(BorderFactory.createEmptyBorder(10,25,10,10)); // مسافة
//
//    panel0.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//
//    setLayout(new GridLayout(6,0));
//    add(panel4,BorderLayout.NORTH);//smestr
//    //add(new JLabel());
//        add(panel6);//rs
//        add(panel8);
//        add(panel3);//4
//        add(panel5,BorderLayout.SOUTH);//cash
//        
//
//        pack(); // يجعل الإطار يناسب مكوناته
//        
//      
//            
//            
//        }
//}