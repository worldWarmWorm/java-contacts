import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JTextField nameField;

    private JTextField emailField;

    private JRadioButton male;

    private JRadioButton female;

    private JCheckBox agreeCheck;

    public ContactForm() {
        super("Contact form");
        super.setBounds(360, 140, 600, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 5, 10));

        JLabel nameLabel = new JLabel("Input your name");
        nameField = new JTextField("", 1);

        JLabel emailLabel = new JLabel("Input your email");
        emailField = new JTextField("", 1);

        male = new JRadioButton("Male");
        male.setSelected(true);
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        agreeCheck = new JCheckBox("Are you agree?", false);
        JButton submit = new JButton("Send");

        container.add(nameLabel);
        container.add(nameField);
        container.add(emailLabel);
        container.add(emailField);
        container.add(male);
        container.add(female);
        container.add(agreeCheck);
        container.add(submit);

        submit.addActionListener(new ButtonEvent());
    }

    class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String sex = "Male";

            if (!male.isSelected()) {
                sex = "Female";
            }

            String agreement = agreeCheck.isSelected() ? "Yes" : "No";

            JOptionPane.showMessageDialog(
                null,
                "Your email: " + email + "\n" +
                    "You sex: " + sex + "\n" +
                    "Agreement is checked: " + agreement,
                "Hello, " + name,
                JOptionPane.PLAIN_MESSAGE
            );
        }
    }
}
