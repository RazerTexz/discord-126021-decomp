package b.i.e.q;

/* JADX INFO: renamed from: b.i.e.q.b, reason: use source file name */
/* JADX INFO: compiled from: Code128Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Code128Reader extends OneDReader {
    public static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0188  */
    /* JADX WARN: Code duplicated, block: B:101:0x018c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0192  */
    /* JADX WARN: Code duplicated, block: B:103:0x0195  */
    /* JADX WARN: Code duplicated, block: B:104:0x0197 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0199 A[PHI: r19
      0x0199: PHI (r19v18 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:104:0x0197, B:78:0x014b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x01a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a3 A[PHI: r19
      0x01a3: PHI (r19v16 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:107:0x01a1, B:81:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:109:0x01a9 A[PHI: r19
      0x01a9: PHI (r19v15 boolean) = (r19v9 boolean), (r19v9 boolean), (r19v19 boolean), (r19v19 boolean) binds: [B:106:0x019f, B:107:0x01a1, B:80:0x014e, B:81:0x0150] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:110:0x01ab A[PHI: r19
      0x01ab: PHI (r19v12 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:95:0x017c, B:70:0x0130] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:111:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:112:0x01b5 A[PHI: r3 r18 r19
      0x01b5: PHI (r3v13 ??) = 
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v20 ??)
      (r3v24 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
      (r3v6 ??)
     binds: [B:53:0x00f5, B:95:0x017c, B:97:0x0180, B:101:0x018c, B:100:0x0188, B:85:0x015c, B:109:0x01a9, B:90:0x0172, B:70:0x0130, B:72:0x0135, B:76:0x0142, B:75:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r18v2 boolean) = 
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v5 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
      (r18v1 boolean)
     binds: [B:53:0x00f5, B:95:0x017c, B:97:0x0180, B:101:0x018c, B:100:0x0188, B:85:0x015c, B:109:0x01a9, B:90:0x0172, B:70:0x0130, B:72:0x0135, B:76:0x0142, B:75:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r19v3 boolean) = 
      (r19v2 boolean)
      (r19v9 boolean)
      (r19v9 boolean)
      (r19v9 boolean)
      (r19v9 boolean)
      (r19v11 boolean)
      (r19v15 boolean)
      (r19v2 boolean)
      (r19v19 boolean)
      (r19v19 boolean)
      (r19v19 boolean)
      (r19v19 boolean)
     binds: [B:53:0x00f5, B:95:0x017c, B:97:0x0180, B:101:0x018c, B:100:0x0188, B:85:0x015c, B:109:0x01a9, B:90:0x0172, B:70:0x0130, B:72:0x0135, B:76:0x0142, B:75:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:113:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:117:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:121:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:123:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:128:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:130:0x01e7 A[PHI: r19
      0x01e7: PHI (r19v8 boolean) = (r19v5 boolean), (r19v9 boolean) binds: [B:123:0x01d1, B:102:0x0192] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:132:0x01eb A[PHI: r19
      0x01eb: PHI (r19v14 boolean) = (r19v5 boolean), (r19v19 boolean) binds: [B:123:0x01d1, B:83:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f3 A[FALL_THROUGH, PHI: r3 r18 r19
      0x01f3: PHI (r3v14 ??) = (r3v13 ??), (r3v6 ??), (r3v6 ??), (r3v6 ??), (r3v6 ??), (r3v6 ??) binds: [B:112:0x01b5, B:123:0x01d1, B:125:0x01d5, B:129:0x01e1, B:128:0x01dd, B:118:0x01c5] A[DONT_GENERATE, DONT_INLINE]
      0x01f3: PHI (r18v3 boolean) = (r18v2 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean) binds: [B:112:0x01b5, B:123:0x01d1, B:125:0x01d5, B:129:0x01e1, B:128:0x01dd, B:118:0x01c5] A[DONT_GENERATE, DONT_INLINE]
      0x01f3: PHI (r19v4 boolean) = (r19v3 boolean), (r19v5 boolean), (r19v5 boolean), (r19v5 boolean), (r19v5 boolean), (r19v2 boolean) binds: [B:112:0x01b5, B:123:0x01d1, B:125:0x01d5, B:129:0x01e1, B:128:0x01dd, B:118:0x01c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:138:0x01f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:140:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:182:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7 A[LOOP:4: B:49:0x00e5->B:50:0x00e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:59:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0105  */
    /* JADX WARN: Code duplicated, block: B:61:0x010d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x011a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0121  */
    /* JADX WARN: Code duplicated, block: B:66:0x0128  */
    /* JADX WARN: Code duplicated, block: B:68:0x012c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0130  */
    /* JADX WARN: Code duplicated, block: B:72:0x0135  */
    /* JADX WARN: Code duplicated, block: B:73:0x0137  */
    /* JADX WARN: Code duplicated, block: B:75:0x013d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0142  */
    /* JADX WARN: Code duplicated, block: B:77:0x0149  */
    /* JADX WARN: Code duplicated, block: B:78:0x014b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x0150 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x0153  */
    /* JADX WARN: Code duplicated, block: B:84:0x0157  */
    /* JADX WARN: Code duplicated, block: B:85:0x015c A[PHI: r19
      0x015c: PHI (r19v11 boolean) = (r19v9 boolean), (r19v19 boolean) binds: [B:94:0x017a, B:69:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x015f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0163  */
    /* JADX WARN: Code duplicated, block: B:89:0x016a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0174  */
    /* JADX WARN: Code duplicated, block: B:93:0x0178  */
    /* JADX WARN: Code duplicated, block: B:95:0x017c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0180  */
    /* JADX WARN: Code duplicated, block: B:98:0x0182  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r27v0, types: [b.i.e.n.a] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // b.i.e.q.OneDReader
    public com.google.zxing.Result b(int r26, b.i.e.n.BitArray r27, java.util.Map<b.i.e.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.e.q.Code128Reader.b(int, b.i.e.n.a, java.util.Map):com.google.zxing.Result");
    }
}
