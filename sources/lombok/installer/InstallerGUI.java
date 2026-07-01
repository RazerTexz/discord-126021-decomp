package lombok.installer;

import com.adjust.sdk.Constants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import lombok.core.Version;

/* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI.SCL.lombok */
public class InstallerGUI {
    private static final int INSTALLER_WINDOW_WIDTH = 662;
    static final AtomicReference<Integer> exitMarker = new AtomicReference<>();
    private JComponent loadingExpl;
    private Component javacArea;
    private Component ideArea;
    private Component uninstallArea;
    private Component howIWorkArea;
    private Component successArea;
    private Box uninstallBox;
    private InstallerGUI$JHyperLink uninstallButton;
    private JLabel uninstallPlaceholder;
    private JButton installButton;
    private List<IdeLocation> toUninstall;
    private JLabel successExplanation;
    private static final String IDE_TITLE = "<html><font size=\"+1\"><b><i>IDEs </i></b></font></html>";
    private static final String IDE_EXPLANATION = "<html>Lombok can update your Eclipse or eclipse-based IDE to fully support all Lombok features.<br>Select IDE installations below and hit 'Install/Update'.</html>";
    private static final String IDE_LOADING_EXPLANATION = "Scanning your drives for IDE installations...";
    private static final String JAVAC_TITLE = "<html><font size=\"+1\"><b><i>Javac </i></b></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (and tools that invoke javac such as <i>ant</i> and <i>maven</i>)</html>";
    private static final String JAVAC_EXPLANATION = "<html>Lombok works 'out of the box' with javac.<br>Just make sure the lombok.jar is in your classpath when you compile.";
    private static final String JAVAC_EXAMPLE = "<html>Example: <code>javac -cp lombok.jar MyCode.java</code></html>";
    private static final String UNINSTALL_TITLE = "<html><font size=\"+1\"><b><i>Uninstall </i></b></font></html>";
    private static final String UNINSTALL_EXPLANATION = "<html>Uninstall Lombok from the following IDE Installations?</html>";
    private static final String HOW_I_WORK_TITLE = "<html><font size=\"+1\"><b><i>What this installer does </i></b></font></html>";
    private static final String HOW_I_WORK_EXPLANATION = "<html><h2>Eclipse</h2><ol><li>First, I copy myself (lombok.jar) to your Eclipse install directory.</li><li>Then, I edit the <i>eclipse.ini</i> file to add the following entry:<br><pre>-javaagent:lombok.jar</pre></li></ol>On Mac OS X, eclipse.ini is hidden in<br><code>Eclipse.app/Contents/MacOS</code> so that's where I place the jar files.</html>";
    private static final String SUCCESS_TITLE = "<html><font size=\"+1\"><b><i>Install successful </i></b></font></html>";
    private static final String SUCCESS_EXPLANATION = "<html>Lombok has been installed on the selected IDE installations.<br>Don't forget to:<ul><li> add <code>lombok.jar</code> to your projects,<li><b>exit and start</b> your IDE,<li><b>rebuild</b> all projects!</ul>%%%</html>";
    private final Set<String> installSpecificMessages = new LinkedHashSet();
    private InstallerGUI$IdesList idesList = new InstallerGUI$IdesList(this);
    private JFrame appWindow = new JFrame(String.format("Project Lombok v%s - Installer", Version.getVersion()));

    static /* synthetic */ JFrame access$0(InstallerGUI installerGUI) {
        return installerGUI.appWindow;
    }

    static /* synthetic */ JComponent access$9(InstallerGUI installerGUI) {
        return installerGUI.loadingExpl;
    }

    static /* synthetic */ Component access$2(InstallerGUI installerGUI) {
        return installerGUI.javacArea;
    }

    static /* synthetic */ Component access$3(InstallerGUI installerGUI) {
        return installerGUI.ideArea;
    }

    static /* synthetic */ Component access$5(InstallerGUI installerGUI) {
        return installerGUI.uninstallArea;
    }

    static /* synthetic */ Component access$1(InstallerGUI installerGUI) {
        return installerGUI.howIWorkArea;
    }

    static /* synthetic */ Component access$4(InstallerGUI installerGUI) {
        return installerGUI.successArea;
    }

    static /* synthetic */ List access$15(InstallerGUI installerGUI) {
        return installerGUI.toUninstall;
    }

    static /* synthetic */ Set access$13(InstallerGUI installerGUI) {
        return installerGUI.installSpecificMessages;
    }

    public InstallerGUI() {
        this.appWindow.setLocationByPlatform(true);
        this.appWindow.setDefaultCloseOperation(3);
        this.appWindow.setResizable(false);
        this.appWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(Installer.class.getResource("lombokIcon.png")));
        try {
            this.javacArea = buildJavacArea();
            this.ideArea = buildIdeArea();
            this.uninstallArea = buildUninstallArea();
            this.uninstallArea.setVisible(false);
            this.howIWorkArea = buildHowIWorkArea();
            this.howIWorkArea.setVisible(false);
            this.successArea = buildSuccessArea();
            this.successArea.setVisible(false);
            buildChrome(this.appWindow.getContentPane());
            this.appWindow.pack();
        } catch (Throwable t) {
            handleException(t);
        }
    }

    static /* synthetic */ void access$8(InstallerGUI installerGUI, Throwable th) {
        installerGUI.handleException(th);
    }

    private void handleException(Throwable t) {
        SwingUtilities.invokeLater(new InstallerGUI$1(this, t));
    }

    private Component buildHowIWorkArea() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 17;
        container.add(new JLabel(HOW_I_WORK_TITLE), constraints);
        constraints.gridy = 1;
        constraints.insets = new Insets(8, 0, 0, 16);
        container.add(new JLabel(String.format(HOW_I_WORK_EXPLANATION, File.separator)), constraints);
        Box buttonBar = Box.createHorizontalBox();
        JButton backButton = new JButton("Okay - Good to know!");
        buttonBar.add(Box.createHorizontalGlue());
        buttonBar.add(backButton);
        backButton.addActionListener(new InstallerGUI$2(this));
        constraints.gridy = 2;
        container.add(buttonBar, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        return container;
    }

    static /* synthetic */ void access$14(InstallerGUI installerGUI, String str) {
        installerGUI.showSuccess(str);
    }

    private void showSuccess(String installSpecific) {
        this.successExplanation.setText(SUCCESS_EXPLANATION.replace("%%%", installSpecific));
        this.howIWorkArea.setVisible(false);
        this.javacArea.setVisible(false);
        this.ideArea.setVisible(false);
        this.successArea.setVisible(true);
        this.appWindow.pack();
    }

    private Component buildSuccessArea() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 17;
        JLabel title = new JLabel(SUCCESS_TITLE);
        container.add(title, constraints);
        title.setPreferredSize(new Dimension(580, 20));
        title.setMinimumSize(new Dimension(580, 20));
        constraints.gridy = 1;
        constraints.insets = new Insets(8, 0, 0, 16);
        JLabel jLabel = new JLabel(SUCCESS_EXPLANATION);
        this.successExplanation = jLabel;
        container.add(jLabel, constraints);
        this.successExplanation.setPreferredSize(new Dimension(580, 175));
        this.successExplanation.setMinimumSize(new Dimension(580, 175));
        constraints.gridy++;
        constraints.fill = 1;
        JTextPane notes = new JTextPane();
        notes.setContentType("text/html");
        notes.setText(readChangeLog());
        notes.setEditable(false);
        notes.setOpaque(false);
        notes.setBorder((Border) null);
        notes.setSelectionStart(0);
        notes.setSelectionEnd(0);
        Font font = UIManager.getFont("Label.font");
        String bodyRule = "body { font-family: " + font.getFamily() + "; font-size: " + font.getSize() + "pt; }";
        notes.getDocument().getStyleSheet().addRule(bodyRule);
        JScrollPane scroller = new JScrollPane(notes);
        container.add(scroller, constraints);
        scroller.setPreferredSize(new Dimension(580, 200));
        scroller.setMinimumSize(new Dimension(580, 200));
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        return container;
    }

    private String readChangeLog() {
        InputStream in = Installer.class.getResourceAsStream("/latestchanges.html");
        try {
            char[] buff = new char[8192];
            StringBuilder contents = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, Constants.ENCODING);
            while (true) {
                int read = reader.read(buff);
                if (read == -1) {
                    break;
                }
                contents.append(buff, 0, read);
            }
            return "<html>" + ((Object) contents) + "</html>";
        } catch (Exception unused) {
            try {
                return "No Changelog available";
            } catch (Exception unused2) {
                return "No Changelog available";
            }
        } finally {
            try {
                in.close();
            } catch (Exception unused3) {
            }
        }
    }

    private Component buildUninstallArea() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 17;
        container.add(new JLabel(UNINSTALL_TITLE), constraints);
        constraints.gridy = 1;
        constraints.insets = new Insets(8, 0, 0, 16);
        container.add(new JLabel(UNINSTALL_EXPLANATION), constraints);
        this.uninstallBox = Box.createVerticalBox();
        constraints.gridy = 2;
        constraints.fill = 2;
        container.add(this.uninstallBox, constraints);
        constraints.fill = 2;
        constraints.gridy = 3;
        container.add(new JLabel("Are you sure?"), constraints);
        Box buttonBar = Box.createHorizontalBox();
        JButton noButton = new JButton("No - Don't uninstall");
        buttonBar.add(noButton);
        buttonBar.add(Box.createHorizontalGlue());
        JButton yesButton = new JButton("Yes - uninstall Lombok");
        buttonBar.add(yesButton);
        noButton.addActionListener(new InstallerGUI$3(this));
        yesButton.addActionListener(new InstallerGUI$4(this));
        constraints.gridy = 4;
        container.add(buttonBar, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        return container;
    }

    private Component buildJavacArea() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 17;
        constraints.insets = new Insets(8, 0, 0, 16);
        container.add(new JLabel(JAVAC_TITLE), constraints);
        constraints.gridy = 1;
        constraints.weightx = 1.0d;
        constraints.fill = 2;
        container.add(new JLabel(JAVAC_EXPLANATION), constraints);
        JLabel example = new JLabel(JAVAC_EXAMPLE);
        constraints.gridy = 2;
        container.add(example, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 105));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 105));
        return container;
    }

    private Component buildIdeArea() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = 17;
        constraints.insets = new Insets(8, 0, 0, 16);
        container.add(new JLabel(IDE_TITLE), constraints);
        constraints.gridy = 1;
        container.add(new JLabel(IDE_EXPLANATION), constraints);
        constraints.gridy = 2;
        this.loadingExpl = Box.createHorizontalBox();
        this.loadingExpl.add(new JLabel(new ImageIcon(Installer.class.getResource("loading.gif"))));
        this.loadingExpl.add(new JLabel(IDE_LOADING_EXPLANATION));
        container.add(this.loadingExpl, constraints);
        constraints.weightx = 1.0d;
        constraints.gridy = 3;
        constraints.fill = 2;
        this.idesList = new InstallerGUI$IdesList(this);
        JScrollPane idesListScroll = new JScrollPane(this.idesList);
        idesListScroll.setBackground(Color.WHITE);
        idesListScroll.getViewport().setBackground(Color.WHITE);
        container.add(idesListScroll, constraints);
        Thread findIdesThread = new InstallerGUI$5(this);
        findIdesThread.start();
        Box buttonBar = Box.createHorizontalBox();
        JButton specifyIdeLocationButton = new JButton("Specify location...");
        buttonBar.add(specifyIdeLocationButton);
        specifyIdeLocationButton.addActionListener(new InstallerGUI$6(this));
        buttonBar.add(Box.createHorizontalGlue());
        this.installButton = new JButton("Install / Update");
        buttonBar.add(this.installButton);
        this.installButton.addActionListener(new InstallerGUI$7(this));
        constraints.gridy = 4;
        constraints.weightx = 0.0d;
        container.add(buttonBar, constraints);
        constraints.gridy = 5;
        constraints.fill = 0;
        InstallerGUI$JHyperLink showMe = new InstallerGUI$JHyperLink("Show me what this installer will do to my IDE installation.");
        container.add(showMe, constraints);
        showMe.addActionListener(new InstallerGUI$8(this));
        constraints.gridy = 6;
        this.uninstallButton = new InstallerGUI$JHyperLink("Uninstall lombok from selected IDE installations.");
        this.uninstallPlaceholder = new JLabel("<html>&nbsp;</html>");
        this.uninstallButton.addActionListener(new InstallerGUI$9(this));
        container.add(this.uninstallButton, constraints);
        this.uninstallPlaceholder.setVisible(false);
        container.add(this.uninstallPlaceholder, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 296));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 296));
        return container;
    }

    static /* synthetic */ void access$11(InstallerGUI installerGUI) {
        installerGUI.showWhatIDo();
    }

    private void showWhatIDo() {
        this.javacArea.setVisible(false);
        this.ideArea.setVisible(false);
        this.howIWorkArea.setVisible(true);
        this.successArea.setVisible(false);
        this.appWindow.pack();
    }

    static /* synthetic */ void access$12(InstallerGUI installerGUI, List list) {
        installerGUI.uninstall(list);
    }

    private void uninstall(List<IdeLocation> locations) {
        this.javacArea.setVisible(false);
        this.ideArea.setVisible(false);
        this.uninstallBox.removeAll();
        this.uninstallBox.add(Box.createRigidArea(new Dimension(1, 16)));
        for (IdeLocation location : locations) {
            JLabel label = new JLabel(location.getName());
            label.setFont(label.getFont().deriveFont(1));
            this.uninstallBox.add(label);
        }
        this.uninstallBox.add(Box.createRigidArea(new Dimension(1, 16)));
        this.toUninstall = locations;
        this.uninstallArea.setVisible(true);
        this.appWindow.pack();
    }

    static /* synthetic */ void access$10(InstallerGUI installerGUI, List list) {
        installerGUI.install(list);
    }

    private void install(List<IdeLocation> toInstall) {
        JPanel spinner = new JPanel();
        spinner.setOpaque(true);
        spinner.setLayout(new FlowLayout());
        spinner.add(new JLabel(new ImageIcon(Installer.class.getResource("loading.gif"))));
        Container appWindowContent = this.appWindow.getContentPane();
        this.appWindow.setContentPane(spinner);
        AtomicInteger successes = new AtomicInteger();
        AtomicBoolean failure = new AtomicBoolean();
        new InstallerGUI$10(this, toInstall, successes, failure, appWindowContent).start();
    }

    static /* synthetic */ void access$6(InstallerGUI installerGUI) {
        installerGUI.doUninstall();
    }

    private void doUninstall() {
        JPanel spinner = new JPanel();
        spinner.setOpaque(true);
        spinner.setLayout(new FlowLayout());
        spinner.add(new JLabel(new ImageIcon(Installer.class.getResource("/lombok/installer/loading.gif"))));
        Container originalContentPane = this.appWindow.getContentPane();
        this.appWindow.setContentPane(spinner);
        AtomicInteger successes = new AtomicInteger();
        new Thread(new InstallerGUI$11(this, successes, originalContentPane)).start();
    }

    static /* synthetic */ InstallerGUI$IdesList access$7(InstallerGUI installerGUI) {
        return installerGUI.idesList;
    }

    void selectedLomboksChanged(List<IdeLocation> selectedIdes) {
        boolean uninstallAvailable = false;
        boolean installAvailable = false;
        for (IdeLocation loc : selectedIdes) {
            if (loc.hasLombok()) {
                uninstallAvailable = true;
            }
            installAvailable = true;
        }
        this.uninstallButton.setVisible(uninstallAvailable);
        this.uninstallPlaceholder.setVisible(!uninstallAvailable);
        this.installButton.setEnabled(installAvailable);
    }

    private void buildChrome(Container appWindowContainer) {
        JLabel leftGraphic = new JLabel(new ImageIcon(Installer.class.getResource("lombok.png")));
        GridBagConstraints constraints = new GridBagConstraints();
        appWindowContainer.setLayout(new GridBagLayout());
        constraints.gridheight = 3;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(8, 8, 8, 8);
        appWindowContainer.add(leftGraphic, constraints);
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridx++;
        constraints.gridy++;
        constraints.gridheight = 1;
        constraints.fill = 2;
        constraints.ipadx = 16;
        constraints.ipady = 14;
        appWindowContainer.add(this.javacArea, constraints);
        constraints.gridy++;
        appWindowContainer.add(this.ideArea, constraints);
        appWindowContainer.add(this.uninstallArea, constraints);
        appWindowContainer.add(this.howIWorkArea, constraints);
        appWindowContainer.add(this.successArea, constraints);
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.weightx = 0.0d;
        constraints.weighty = 0.0d;
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.fill = 2;
        constraints.anchor = 16;
        constraints.insets = new Insets(0, 16, 8, 8);
        this.appWindow.add(buildButtonBar(), constraints);
    }

    private Box buildButtonBar() {
        Box buttonBar = Box.createHorizontalBox();
        InstallerGUI$JHyperLink aboutLink = new InstallerGUI$JHyperLink(Installer.ABOUT_LOMBOK_URL.toString());
        aboutLink.addActionListener(openBrowser(aboutLink, Installer.ABOUT_LOMBOK_URL));
        buttonBar.add(aboutLink);
        buttonBar.add(Box.createRigidArea(new Dimension(16, 1)));
        JLabel versionLabel = new JLabel();
        versionLabel.setText("v" + Version.getVersion());
        buttonBar.add(versionLabel);
        buttonBar.add(Box.createRigidArea(new Dimension(16, 1)));
        InstallerGUI$JHyperLink changelogLink = new InstallerGUI$JHyperLink("View full changelog");
        changelogLink.addActionListener(openBrowser(changelogLink, Installer.ABOUT_LOMBOK_URL.resolve("/changelog.html")));
        buttonBar.add(changelogLink);
        buttonBar.add(Box.createHorizontalGlue());
        JButton quitButton = new JButton("Quit Installer");
        quitButton.addActionListener(new InstallerGUI$12(this));
        buttonBar.add(quitButton);
        return buttonBar;
    }

    private ActionListener openBrowser(InstallerGUI$JHyperLink hyperlink, URI location) {
        return new InstallerGUI$13(this, hyperlink, location);
    }

    public void show() {
        this.appWindow.setVisible(true);
        if (OsUtils.getOS() == OsUtils$OS.MAC_OS_X) {
            try {
                AppleNativeLook.go();
            } catch (Throwable unused) {
            }
        }
    }
}
