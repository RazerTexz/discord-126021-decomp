package lombok.patcher;

/* JADX INFO: loaded from: app.apk:lombok/patcher/TransplantMapper.SCL.lombok */
public interface TransplantMapper {
    public static final TransplantMapper IDENTITY_MAPPER = new TransplantMapper$1();

    String mapResourceName(int i, String str);
}
