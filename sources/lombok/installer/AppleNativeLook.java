package lombok.installer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/AppleNativeLook.SCL.lombok */
class AppleNativeLook {
    AppleNativeLook() {
    }

    /* JADX INFO: renamed from: go */
    public static void m10938go() throws Exception {
        Class<?> appClass = Class.forName("com.apple.eawt.Application");
        Object app = appClass.getMethod("getApplication", new Class[0]).invoke(null, new Object[0]);
        appClass.getMethod("removeAboutMenuItem", new Class[0]).invoke(app, new Object[0]);
        appClass.getMethod("removePreferencesMenuItem", new Class[0]).invoke(app, new Object[0]);
        BufferedImage image = ImageIO.read(AppleNativeLook.class.getResource("lombokIcon.png"));
        appClass.getMethod("setDockIconImage", Image.class).invoke(app, image);
    }
}
