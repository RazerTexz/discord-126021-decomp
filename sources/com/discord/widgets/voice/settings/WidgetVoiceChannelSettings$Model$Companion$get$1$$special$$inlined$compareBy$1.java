package com.discord.widgets.voice.settings;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelVoiceRegion;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1<T> implements Comparator {
    public final /* synthetic */ Comparator $comparator;

    public WidgetVoiceChannelSettings$Model$Companion$get$1$$special$$inlined$compareBy$1(Comparator comparator) {
        this.$comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return this.$comparator.compare(((ModelVoiceRegion) t).getName(), ((ModelVoiceRegion) t2).getName());
    }
}
