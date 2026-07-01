package b.a.m.a.h0;

import android.os.Parcelable$Creator;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Model$JsonReader$ItemFactory {
    public final /* synthetic */ Model$JsonReader a;

    public /* synthetic */ c(Model$JsonReader model$JsonReader) {
        this.a = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Object get() {
        Model$JsonReader model$JsonReader = this.a;
        Parcelable$Creator<ModelEmojiUnicode> parcelable$Creator = ModelEmojiUnicode.CREATOR;
        return model$JsonReader.nextString(null);
    }
}
