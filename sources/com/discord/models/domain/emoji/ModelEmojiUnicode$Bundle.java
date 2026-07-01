package com.discord.models.domain.emoji;

import b.a.m.a.h0.a;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ModelEmojiUnicode$Bundle implements Model {
    private Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = new HashMap();

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        EmojiCategory byString = EmojiCategory.getByString(model$JsonReader.nextName());
        if (byString != null) {
            this.emojis.put(byString, model$JsonReader.nextList(new a(model$JsonReader)));
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelEmojiUnicode$Bundle;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelEmojiUnicode$Bundle)) {
            return false;
        }
        ModelEmojiUnicode$Bundle modelEmojiUnicode$Bundle = (ModelEmojiUnicode$Bundle) obj;
        if (!modelEmojiUnicode$Bundle.canEqual(this)) {
            return false;
        }
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = getEmojis();
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis2 = modelEmojiUnicode$Bundle.getEmojis();
        return emojis != null ? emojis.equals(emojis2) : emojis2 == null;
    }

    public Map<EmojiCategory, List<ModelEmojiUnicode>> getEmojis() {
        return this.emojis;
    }

    public int hashCode() {
        Map<EmojiCategory, List<ModelEmojiUnicode>> emojis = getEmojis();
        return 59 + (emojis == null ? 43 : emojis.hashCode());
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ModelEmojiUnicode.Bundle(emojis=");
        sbU.append(getEmojis());
        sbU.append(")");
        return sbU.toString();
    }
}
