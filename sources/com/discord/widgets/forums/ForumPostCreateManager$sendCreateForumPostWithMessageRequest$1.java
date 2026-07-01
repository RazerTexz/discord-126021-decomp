package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSend;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import okhttp3.MultipartBody$Part;
import rx.Observable;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$sendCreateForumPostWithMessageRequest$1<T, R> implements b<SendUtils$SendPayload$ReadyToSend, Observable<? extends Channel>> {
    public final /* synthetic */ List $appliedTags;
    public final /* synthetic */ int $autoArchiveDuration;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $name;
    public final /* synthetic */ List $stickerIds;

    public ForumPostCreateManager$sendCreateForumPostWithMessageRequest$1(long j, String str, List list, List list2, int i) {
        this.$channelId = j;
        this.$name = str;
        this.$appliedTags = list;
        this.$stickerIds = list2;
        this.$autoArchiveDuration = i;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend) {
        return call2(sendUtils$SendPayload$ReadyToSend);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend) {
        List<SendUtils$FileUpload> uploads = sendUtils$SendPayload$ReadyToSend.getUploads();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(uploads, 10));
        Iterator<T> it = uploads.iterator();
        while (it.hasNext()) {
            arrayList.add(((SendUtils$FileUpload) it.next()).getPart());
        }
        RestAPI api = RestAPI.Companion.getApi();
        long j = this.$channelId;
        String str = this.$name;
        String content = sendUtils$SendPayload$ReadyToSend.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        String str2 = content;
        List<Long> list = this.$appliedTags;
        List<Long> list2 = this.$stickerIds;
        Integer numValueOf = Integer.valueOf(this.$autoArchiveDuration);
        Object[] array = arrayList.toArray(new MultipartBody$Part[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return api.createThreadWithMessage(j, str, str2, list, list2, 11, numValueOf, (MultipartBody$Part[]) array);
    }
}
