package p007b.p225i.p414e;

import java.util.List;

/* JADX INFO: renamed from: b.i.e.d */
/* JADX INFO: compiled from: DecodeHintType.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC4949d {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(InterfaceC4957l.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> valueType;

    EnumC4949d(Class cls) {
        this.valueType = cls;
    }
}
