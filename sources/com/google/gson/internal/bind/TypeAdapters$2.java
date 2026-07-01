package com.google.gson.internal.bind;

import b.d.b.a.a;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$2 extends TypeAdapter<BitSet> {
    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    @Override // com.google.gson.TypeAdapter
    public BitSet read(JsonReader jsonReader) throws IOException {
        boolean zU;
        BitSet bitSet = new BitSet();
        jsonReader.a();
        JsonToken jsonTokenN = jsonReader.N();
        int i = 0;
        while (jsonTokenN != JsonToken.END_ARRAY) {
            int iOrdinal = jsonTokenN.ordinal();
            if (iOrdinal == 5) {
                String strJ = jsonReader.J();
                try {
                    if (Integer.parseInt(strJ) != 0) {
                        zU = true;
                    } else {
                        zU = false;
                    }
                } catch (NumberFormatException unused) {
                    throw new JsonSyntaxException(a.w("Error: Expecting: bitset number value (1, 0), Found: ", strJ));
                }
            } else if (iOrdinal != 6) {
                if (iOrdinal != 7) {
                    throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenN);
                }
                zU = jsonReader.u();
            } else if (jsonReader.y() != 0) {
                zU = true;
            } else {
                zU = false;
            }
            if (zU) {
                bitSet.set(i);
            }
            i++;
            jsonTokenN = jsonReader.N();
        }
        jsonReader.e();
        return bitSet;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
        BitSet bitSet2 = bitSet;
        jsonWriter.b();
        int length = bitSet2.length();
        for (int i = 0; i < length; i++) {
            jsonWriter.A(bitSet2.get(i) ? 1L : 0L);
        }
        jsonWriter.e();
    }
}
