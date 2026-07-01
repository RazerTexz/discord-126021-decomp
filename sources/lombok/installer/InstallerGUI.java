package lombok.installer;

import com.adjust.sdk.Constants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import lombok.core.Version;
import lombok.installer.OsUtils;
import org.objectweb.asm.Opcodes;

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
    private JHyperLink uninstallButton;
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
    private IdesList idesList = new IdesList();
    private JFrame appWindow = new JFrame(String.format("Project Lombok v%s - Installer", Version.getVersion()));

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

    private void handleException(final Throwable t) {
        SwingUtilities.invokeLater(new Runnable() { // from class: lombok.installer.InstallerGUI.1
            @Override // java.lang.Runnable
            public void run() {
                JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "There was a problem during the installation process:\n" + t, "Uh Oh!", 0);
                t.printStackTrace();
                System.exit(1);
            }
        });
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
        backButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.2
            public void actionPerformed(ActionEvent e) {
                InstallerGUI.this.howIWorkArea.setVisible(false);
                InstallerGUI.this.javacArea.setVisible(true);
                InstallerGUI.this.ideArea.setVisible(true);
                InstallerGUI.this.successArea.setVisible(false);
                InstallerGUI.this.appWindow.pack();
            }
        });
        constraints.gridy = 2;
        container.add(buttonBar, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 415));
        return container;
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
        noButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.3
            public void actionPerformed(ActionEvent e) {
                InstallerGUI.this.uninstallArea.setVisible(false);
                InstallerGUI.this.javacArea.setVisible(true);
                InstallerGUI.this.ideArea.setVisible(true);
                InstallerGUI.this.appWindow.pack();
            }
        });
        yesButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.4
            public void actionPerformed(ActionEvent e) {
                InstallerGUI.this.doUninstall();
            }
        });
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
        this.idesList = new IdesList();
        JScrollPane idesListScroll = new JScrollPane(this.idesList);
        idesListScroll.setBackground(Color.WHITE);
        idesListScroll.getViewport().setBackground(Color.WHITE);
        container.add(idesListScroll, constraints);
        Thread findIdesThread = new Thread() { // from class: lombok.installer.InstallerGUI.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    final List<IdeLocation> locations = new ArrayList<>();
                    final List<CorruptedIdeLocationException> problems = new ArrayList<>();
                    Installer.autoDiscover(locations, problems);
                    SwingUtilities.invokeLater(new Runnable() { // from class: lombok.installer.InstallerGUI.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            for (IdeLocation location : locations) {
                                try {
                                    InstallerGUI.this.idesList.addLocation(location);
                                } catch (Throwable t) {
                                    InstallerGUI.this.handleException(t);
                                }
                            }
                            for (CorruptedIdeLocationException problem : problems) {
                                problem.showDialog(InstallerGUI.this.appWindow);
                            }
                            InstallerGUI.this.loadingExpl.setVisible(false);
                            if (locations.size() + problems.size() == 0) {
                                JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "I can't find any IDEs on your computer.\nIf you have IDEs installed on this computer, please use the 'Specify Location...' button to manually point out the \nlocation of your IDE installation to me. Thanks!", "Can't find IDE", 1);
                            }
                        }
                    });
                } catch (Throwable t) {
                    InstallerGUI.this.handleException(t);
                }
            }
        };
        findIdesThread.start();
        Box buttonBar = Box.createHorizontalBox();
        JButton specifyIdeLocationButton = new JButton("Specify location...");
        buttonBar.add(specifyIdeLocationButton);
        specifyIdeLocationButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.6
            public void actionPerformed(ActionEvent event) {
                final List<Pattern> exeNames = Installer.getIdeExecutableNames();
                String file = null;
                if (OsUtils.getOS() == OsUtils.OS.MAC_OS_X) {
                    FileDialog chooser = new FileDialog(InstallerGUI.this.appWindow);
                    chooser.setMode(0);
                    chooser.setFilenameFilter(new FilenameFilter() { // from class: lombok.installer.InstallerGUI.6.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File dir, String fileName) {
                            for (Pattern exeName : exeNames) {
                                if (exeName.matcher(fileName).matches()) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    });
                    chooser.setVisible(true);
                    if (chooser.getDirectory() != null && chooser.getFile() != null) {
                        file = new File(chooser.getDirectory(), chooser.getFile()).getAbsolutePath();
                    }
                } else {
                    JFileChooser chooser2 = new JFileChooser();
                    chooser2.setAcceptAllFileFilterUsed(false);
                    chooser2.setFileSelectionMode(2);
                    chooser2.setFileFilter(new FileFilter() { // from class: lombok.installer.InstallerGUI.6.2
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            }
                            for (Pattern exeName : exeNames) {
                                if (exeName.matcher(f.getName()).matches()) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        public String getDescription() {
                            return "IDE Installation";
                        }
                    });
                    switch (chooser2.showDialog(InstallerGUI.this.appWindow, "Select")) {
                        case 0:
                            file = chooser2.getSelectedFile().getAbsolutePath();
                            break;
                    }
                }
                if (file != null) {
                    try {
                        IdeLocation loc = Installer.tryAllProviders(file);
                        if (loc == null) {
                            JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "I can't find any IDE that lombok supports at location: " + file, "No IDE found", 2);
                        } else {
                            InstallerGUI.this.idesList.addLocation(loc);
                        }
                    } catch (CorruptedIdeLocationException e) {
                        e.showDialog(InstallerGUI.this.appWindow);
                    } catch (Throwable t) {
                        InstallerGUI.this.handleException(t);
                    }
                }
            }
        });
        buttonBar.add(Box.createHorizontalGlue());
        this.installButton = new JButton("Install / Update");
        buttonBar.add(this.installButton);
        this.installButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.7
            public void actionPerformed(ActionEvent e) {
                List<IdeLocation> locationsToInstall = new ArrayList<>(InstallerGUI.this.idesList.getSelectedIdes());
                if (locationsToInstall.isEmpty()) {
                    JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "You haven't selected any IDE installations!.", "No Selection", 2);
                } else {
                    InstallerGUI.this.install(locationsToInstall);
                }
            }
        });
        constraints.gridy = 4;
        constraints.weightx = 0.0d;
        container.add(buttonBar, constraints);
        constraints.gridy = 5;
        constraints.fill = 0;
        JHyperLink showMe = new JHyperLink("Show me what this installer will do to my IDE installation.");
        container.add(showMe, constraints);
        showMe.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.8
            public void actionPerformed(ActionEvent e) {
                InstallerGUI.this.showWhatIDo();
            }
        });
        constraints.gridy = 6;
        this.uninstallButton = new JHyperLink("Uninstall lombok from selected IDE installations.");
        this.uninstallPlaceholder = new JLabel("<html>&nbsp;</html>");
        this.uninstallButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.9
            public void actionPerformed(ActionEvent e) {
                List<IdeLocation> locationsToUninstall = new ArrayList<>();
                for (IdeLocation location : InstallerGUI.this.idesList.getSelectedIdes()) {
                    if (location.hasLombok()) {
                        locationsToUninstall.add(location);
                    }
                }
                if (locationsToUninstall.isEmpty()) {
                    JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "You haven't selected any IDE installations that have been lombok-enabled.", "No Selection", 2);
                } else {
                    InstallerGUI.this.uninstall(locationsToUninstall);
                }
            }
        });
        container.add(this.uninstallButton, constraints);
        this.uninstallPlaceholder.setVisible(false);
        container.add(this.uninstallPlaceholder, constraints);
        container.setPreferredSize(new Dimension(INSTALLER_WINDOW_WIDTH, 296));
        container.setMinimumSize(new Dimension(INSTALLER_WINDOW_WIDTH, 296));
        return container;
    }

    private void showWhatIDo() {
        this.javacArea.setVisible(false);
        this.ideArea.setVisible(false);
        this.howIWorkArea.setVisible(true);
        this.successArea.setVisible(false);
        this.appWindow.pack();
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

    /* JADX WARN: Type inference failed for: r0v12, types: [lombok.installer.InstallerGUI$10] */
    private void install(final List<IdeLocation> toInstall) {
        JPanel spinner = new JPanel();
        spinner.setOpaque(true);
        spinner.setLayout(new FlowLayout());
        spinner.add(new JLabel(new ImageIcon(Installer.class.getResource("loading.gif"))));
        final Container appWindowContent = this.appWindow.getContentPane();
        this.appWindow.setContentPane(spinner);
        final AtomicInteger successes = new AtomicInteger();
        final AtomicBoolean failure = new AtomicBoolean();
        new Thread() { // from class: lombok.installer.InstallerGUI.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                for (IdeLocation loc : toInstall) {
                    try {
                        InstallerGUI.this.installSpecificMessages.add(loc.install());
                        successes.incrementAndGet();
                    } catch (InstallException e) {
                        if (e.isWarning()) {
                            try {
                                SwingUtilities.invokeAndWait(new Runnable() { // from class: lombok.installer.InstallerGUI.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, e.getMessage(), "Install Problem", 2);
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                throw new RuntimeException(e2);
                            }
                        } else {
                            failure.set(true);
                            try {
                                SwingUtilities.invokeAndWait(new Runnable() { // from class: lombok.installer.InstallerGUI.10.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, e.getMessage(), "Install Problem", 0);
                                    }
                                });
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                throw new RuntimeException(e3);
                            }
                        }
                    }
                }
                if (successes.get() > 0) {
                    try {
                        final Container container = appWindowContent;
                        SwingUtilities.invokeAndWait(new Runnable() { // from class: lombok.installer.InstallerGUI.10.3
                            @Override // java.lang.Runnable
                            public void run() {
                                InstallerGUI.this.appWindow.setContentPane(container);
                                InstallerGUI.this.appWindow.pack();
                                StringBuilder installSpecific = new StringBuilder();
                                for (String installSpecificMessage : InstallerGUI.this.installSpecificMessages) {
                                    installSpecific.append("<br>").append(installSpecificMessage);
                                }
                                InstallerGUI.this.showSuccess(installSpecific.toString());
                            }
                        });
                        return;
                    } catch (Exception e4) {
                        throw new RuntimeException(e4);
                    }
                }
                final AtomicBoolean atomicBoolean = failure;
                SwingUtilities.invokeLater(new Runnable() { // from class: lombok.installer.InstallerGUI.10.4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.atomic.AtomicReference<java.lang.Integer>] */
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
                    /* JADX WARN: Type inference failed for: r0v4 */
                    @Override // java.lang.Runnable
                    public void run() {
                        ?? r0 = InstallerGUI.exitMarker;
                        synchronized (r0) {
                            try {
                                InstallerGUI.exitMarker.set(Integer.valueOf(atomicBoolean.get() ? 1 : 0));
                                InstallerGUI.exitMarker.notifyAll();
                                r0 = r0;
                            } catch (Throwable th) {
                                throw r0;
                            }
                        }
                    }
                });
            }
        }.start();
    }

    private void doUninstall() {
        JPanel spinner = new JPanel();
        spinner.setOpaque(true);
        spinner.setLayout(new FlowLayout());
        spinner.add(new JLabel(new ImageIcon(Installer.class.getResource("/lombok/installer/loading.gif"))));
        final Container originalContentPane = this.appWindow.getContentPane();
        this.appWindow.setContentPane(spinner);
        final AtomicInteger successes = new AtomicInteger();
        new Thread(new Runnable() { // from class: lombok.installer.InstallerGUI.11
            @Override // java.lang.Runnable
            public void run() {
                for (IdeLocation loc : InstallerGUI.this.toUninstall) {
                    try {
                        loc.uninstall();
                        successes.incrementAndGet();
                    } catch (UninstallException e) {
                        if (e.isWarning()) {
                            try {
                                SwingUtilities.invokeAndWait(new Runnable() { // from class: lombok.installer.InstallerGUI.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, e.getMessage(), "Uninstall Problem", 2);
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                throw new RuntimeException(e2);
                            }
                        } else {
                            try {
                                SwingUtilities.invokeAndWait(new Runnable() { // from class: lombok.installer.InstallerGUI.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, e.getMessage(), "Uninstall Problem", 0);
                                    }
                                });
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                throw new RuntimeException(e3);
                            }
                        }
                    }
                }
                final AtomicInteger atomicInteger = successes;
                final Container container = originalContentPane;
                SwingUtilities.invokeLater(new Runnable() { // from class: lombok.installer.InstallerGUI.11.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicInteger.get() > 0) {
                            JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "Lombok has been removed from the selected IDE installations.", "Uninstall successful", 1);
                            InstallerGUI.this.appWindow.setVisible(false);
                            System.exit(0);
                            return;
                        }
                        InstallerGUI.this.appWindow.setContentPane(container);
                    }
                });
            }
        }).start();
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

    /* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$IdesList.SCL.lombok */
    private class IdesList extends JPanel implements Scrollable {
        private static final long serialVersionUID = 1;
        List<IdeLocation> locations = new ArrayList();

        IdesList() {
            setLayout(new BoxLayout(this, 1));
            setBackground(Color.WHITE);
        }

        List<IdeLocation> getSelectedIdes() {
            List<IdeLocation> list = new ArrayList<>();
            for (IdeLocation loc : this.locations) {
                if (loc.selected) {
                    list.add(loc);
                }
            }
            return list;
        }

        void fireSelectionChange() {
            InstallerGUI.this.selectedLomboksChanged(getSelectedIdes());
        }

        void addLocation(final IdeLocation location) {
            if (this.locations.contains(location)) {
                return;
            }
            Box box = Box.createHorizontalBox();
            box.setBackground(Color.WHITE);
            final JCheckBox checkbox = new JCheckBox(location.getName());
            checkbox.setBackground(Color.WHITE);
            box.add(new JLabel(new ImageIcon(location.getIdeIcon())));
            box.add(checkbox);
            checkbox.setSelected(true);
            checkbox.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.IdesList.1
                public void actionPerformed(ActionEvent e) {
                    location.selected = checkbox.isSelected();
                    IdesList.this.fireSelectionChange();
                }
            });
            if (location.hasLombok()) {
                box.add(new JLabel(new ImageIcon(Installer.class.getResource("lombokIcon.png"))));
            }
            box.add(Box.createHorizontalGlue());
            this.locations.add(location);
            add(box);
            getParent().doLayout();
            fireSelectionChange();
        }

        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(1, 100);
        }

        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 12;
        }

        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 1;
        }
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
        JHyperLink aboutLink = new JHyperLink(Installer.ABOUT_LOMBOK_URL.toString());
        aboutLink.addActionListener(openBrowser(aboutLink, Installer.ABOUT_LOMBOK_URL));
        buttonBar.add(aboutLink);
        buttonBar.add(Box.createRigidArea(new Dimension(16, 1)));
        JLabel versionLabel = new JLabel();
        versionLabel.setText("v" + Version.getVersion());
        buttonBar.add(versionLabel);
        buttonBar.add(Box.createRigidArea(new Dimension(16, 1)));
        JHyperLink changelogLink = new JHyperLink("View full changelog");
        changelogLink.addActionListener(openBrowser(changelogLink, Installer.ABOUT_LOMBOK_URL.resolve("/changelog.html")));
        buttonBar.add(changelogLink);
        buttonBar.add(Box.createHorizontalGlue());
        JButton quitButton = new JButton("Quit Installer");
        quitButton.addActionListener(new ActionListener() { // from class: lombok.installer.InstallerGUI.12
            public void actionPerformed(ActionEvent e) {
                InstallerGUI.this.appWindow.setVisible(false);
                System.exit(0);
            }
        });
        buttonBar.add(quitButton);
        return buttonBar;
    }

    private ActionListener openBrowser(final JHyperLink hyperlink, final URI location) {
        return new ActionListener() { // from class: lombok.installer.InstallerGUI.13
            private static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS;

            static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS() {
                int[] iArr = $SWITCH_TABLE$lombok$installer$OsUtils$OS;
                if (iArr != null) {
                    return iArr;
                }
                int[] iArr2 = new int[OsUtils.OS.valuesCustom().length];
                try {
                    iArr2[OsUtils.OS.MAC_OS_X.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr2[OsUtils.OS.UNIX.ordinal()] = 3;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr2[OsUtils.OS.WINDOWS.ordinal()] = 2;
                } catch (NoSuchFieldError unused3) {
                }
                $SWITCH_TABLE$lombok$installer$OsUtils$OS = iArr2;
                return iArr2;
            }

            public void actionPerformed(ActionEvent event) {
                hyperlink.setForeground(new Color(85, Opcodes.I2B, 90));
                try {
                    Object desktop = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    Class.forName("java.awt.Desktop").getMethod("browse", URI.class).invoke(desktop, location);
                } catch (Exception unused) {
                    Runtime rt = Runtime.getRuntime();
                    try {
                        switch ($SWITCH_TABLE$lombok$installer$OsUtils$OS()[OsUtils.getOS().ordinal()]) {
                            case 1:
                                rt.exec("open " + location.toString());
                                break;
                            case 2:
                                String[] cmd = {"cmd.exe", "/C", "start", location.toString()};
                                rt.exec(cmd);
                                break;
                            case 3:
                            default:
                                rt.exec("firefox " + location.toString());
                                break;
                        }
                    } catch (Exception unused2) {
                        JOptionPane.showMessageDialog(InstallerGUI.this.appWindow, "Well, this is embarrassing. I don't know how to open a webbrowser.\nI guess you'll have to open it. Browse to:\n" + location + " for more information about Lombok.", "I'm embarrassed", 1);
                    }
                }
            }
        };
    }

    public void show() {
        this.appWindow.setVisible(true);
        if (OsUtils.getOS() == OsUtils.OS.MAC_OS_X) {
            try {
                AppleNativeLook.go();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/installer/InstallerGUI$JHyperLink.SCL.lombok */
    private static class JHyperLink extends JButton {
        private static final long serialVersionUID = 1;

        public JHyperLink(String text) {
            setFont(getFont().deriveFont(Collections.singletonMap(TextAttribute.UNDERLINE, 1)));
            setText(text);
            setBorder(null);
            setContentAreaFilled(false);
            setForeground(Color.BLUE);
            setCursor(Cursor.getPredefinedCursor(12));
            setMargin(new Insets(0, 0, 0, 0));
        }
    }
}
