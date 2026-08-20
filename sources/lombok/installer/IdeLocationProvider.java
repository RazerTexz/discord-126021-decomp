package lombok.installer;

import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/IdeLocationProvider.SCL.lombok */
public interface IdeLocationProvider {
    IdeLocation create(String str) throws CorruptedIdeLocationException;

    Pattern getLocationSelectors();

    void findIdes(List<IdeLocation> list, List<CorruptedIdeLocationException> list2);
}
