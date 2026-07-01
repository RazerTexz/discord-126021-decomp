package androidx.core.text;

/* JADX INFO: loaded from: classes.dex */
public class BidiFormatter$DirectionalityEstimator {
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final CharSequence text;
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];

    static {
        for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
            DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
        }
    }

    public BidiFormatter$DirectionalityEstimator(CharSequence charSequence, boolean z2) {
        this.text = charSequence;
        this.isHtml = z2;
        this.length = charSequence.length();
    }

    private static byte getCachedDirectionality(char c) {
        return c < DIR_TYPE_CACHE_SIZE ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
    }

    private byte skipEntityBackward() {
        char cCharAt;
        int i = this.charIndex;
        do {
            int i2 = this.charIndex;
            if (i2 <= 0) {
                break;
            }
            CharSequence charSequence = this.text;
            int i3 = i2 - 1;
            this.charIndex = i3;
            cCharAt = charSequence.charAt(i3);
            this.lastChar = cCharAt;
            if (cCharAt == '&') {
                return (byte) 12;
            }
        } while (cCharAt != ';');
        this.charIndex = i;
        this.lastChar = ';';
        return (byte) 13;
    }

    private byte skipEntityForward() {
        char cCharAt;
        do {
            int i = this.charIndex;
            if (i >= this.length) {
                return (byte) 12;
            }
            CharSequence charSequence = this.text;
            this.charIndex = i + 1;
            cCharAt = charSequence.charAt(i);
            this.lastChar = cCharAt;
        } while (cCharAt != ';');
        return (byte) 12;
    }

    private byte skipTagBackward() {
        char cCharAt;
        int i = this.charIndex;
        while (true) {
            int i2 = this.charIndex;
            if (i2 <= 0) {
                break;
            }
            CharSequence charSequence = this.text;
            int i3 = i2 - 1;
            this.charIndex = i3;
            char cCharAt2 = charSequence.charAt(i3);
            this.lastChar = cCharAt2;
            if (cCharAt2 == '<') {
                return (byte) 12;
            }
            if (cCharAt2 == '>') {
                break;
            }
            if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                do {
                    int i4 = this.charIndex;
                    if (i4 <= 0) {
                        break;
                    }
                    CharSequence charSequence2 = this.text;
                    int i5 = i4 - 1;
                    this.charIndex = i5;
                    cCharAt = charSequence2.charAt(i5);
                    this.lastChar = cCharAt;
                } while (cCharAt != cCharAt2);
            }
        }
        this.charIndex = i;
        this.lastChar = '>';
        return (byte) 13;
    }

    private byte skipTagForward() {
        char cCharAt;
        int i = this.charIndex;
        while (true) {
            int i2 = this.charIndex;
            if (i2 >= this.length) {
                this.charIndex = i;
                this.lastChar = '<';
                return (byte) 13;
            }
            CharSequence charSequence = this.text;
            this.charIndex = i2 + 1;
            char cCharAt2 = charSequence.charAt(i2);
            this.lastChar = cCharAt2;
            if (cCharAt2 == '>') {
                return (byte) 12;
            }
            if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                do {
                    int i3 = this.charIndex;
                    if (i3 >= this.length) {
                        break;
                    }
                    CharSequence charSequence2 = this.text;
                    this.charIndex = i3 + 1;
                    cCharAt = charSequence2.charAt(i3);
                    this.lastChar = cCharAt;
                } while (cCharAt != cCharAt2);
            }
        }
    }

    public byte dirTypeBackward() {
        char cCharAt = this.text.charAt(this.charIndex - 1);
        this.lastChar = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.charIndex--;
        byte cachedDirectionality = getCachedDirectionality(this.lastChar);
        if (!this.isHtml) {
            return cachedDirectionality;
        }
        char c = this.lastChar;
        if (c == '>') {
            return skipTagBackward();
        }
        return c == ';' ? skipEntityBackward() : cachedDirectionality;
    }

    public byte dirTypeForward() {
        char cCharAt = this.text.charAt(this.charIndex);
        this.lastChar = cCharAt;
        if (Character.isHighSurrogate(cCharAt)) {
            int iCodePointAt = Character.codePointAt(this.text, this.charIndex);
            this.charIndex = Character.charCount(iCodePointAt) + this.charIndex;
            return Character.getDirectionality(iCodePointAt);
        }
        this.charIndex++;
        byte cachedDirectionality = getCachedDirectionality(this.lastChar);
        if (!this.isHtml) {
            return cachedDirectionality;
        }
        char c = this.lastChar;
        if (c == '<') {
            return skipTagForward();
        }
        return c == '&' ? skipEntityForward() : cachedDirectionality;
    }

    public int getEntryDir() {
        this.charIndex = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.charIndex < this.length && i == 0) {
            byte bDirTypeForward = dirTypeForward();
            if (bDirTypeForward != 0) {
                if (bDirTypeForward == 1 || bDirTypeForward == 2) {
                    if (i3 == 0) {
                        return 1;
                    }
                } else if (bDirTypeForward != 9) {
                    switch (bDirTypeForward) {
                        case 14:
                        case 15:
                            i3++;
                            i2 = -1;
                            continue;
                        case 16:
                        case 17:
                            i3++;
                            i2 = 1;
                            continue;
                        case 18:
                            i3--;
                            i2 = 0;
                            continue;
                    }
                }
            } else if (i3 == 0) {
                return -1;
            }
            i = i3;
        }
        if (i == 0) {
            return 0;
        }
        if (i2 != 0) {
            return i2;
        }
        while (this.charIndex > 0) {
            switch (dirTypeBackward()) {
                case 14:
                case 15:
                    if (i == i3) {
                        return -1;
                    }
                    break;
                case 16:
                case 17:
                    if (i == i3) {
                        return 1;
                    }
                    break;
                case 18:
                    i3++;
                    continue;
                default:
                    continue;
            }
            i3--;
        }
        return 0;
    }

    public int getExitDir() {
        this.charIndex = this.length;
        int i = 0;
        int i2 = 0;
        while (this.charIndex > 0) {
            byte bDirTypeBackward = dirTypeBackward();
            if (bDirTypeBackward == 0) {
                if (i == 0) {
                    return -1;
                }
                if (i2 == 0) {
                    i2 = i;
                }
            } else if (bDirTypeBackward == 1 || bDirTypeBackward == 2) {
                if (i == 0) {
                    return 1;
                }
                if (i2 == 0) {
                    i2 = i;
                }
            } else if (bDirTypeBackward != 9) {
                switch (bDirTypeBackward) {
                    case 14:
                    case 15:
                        if (i2 == i) {
                            return -1;
                        }
                        i--;
                        break;
                    case 16:
                    case 17:
                        if (i2 == i) {
                            return 1;
                        }
                        i--;
                        break;
                    case 18:
                        i++;
                        break;
                    default:
                        if (i2 == 0) {
                            i2 = i;
                        }
                        break;
                }
            } else {
                continue;
            }
        }
        return 0;
    }
}
