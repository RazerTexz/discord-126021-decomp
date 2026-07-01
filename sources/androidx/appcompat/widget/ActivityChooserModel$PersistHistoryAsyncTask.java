package androidx.appcompat.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import com.adjust.sdk.Constants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityChooserModel$PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
    public final /* synthetic */ ActivityChooserModel this$0;

    public ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel activityChooserModel) {
        this.this$0 = activityChooserModel;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(Object[] objArr) {
        return doInBackground2(objArr);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x006f A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Void doInBackground2(Object... objArr) {
        List list = (List) objArr[0];
        String str = (String) objArr[1];
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = this.this$0.mContext.openFileOutput(str, 0);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            try {
                xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                xmlSerializerNewSerializer.startDocument(Constants.ENCODING, Boolean.TRUE);
                xmlSerializerNewSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord) list.remove(0);
                    xmlSerializerNewSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                    xmlSerializerNewSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, activityChooserModel$HistoricalRecord.activity.flattenToString());
                    xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(activityChooserModel$HistoricalRecord.time));
                    xmlSerializerNewSerializer.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(activityChooserModel$HistoricalRecord.weight));
                    xmlSerializerNewSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                }
                xmlSerializerNewSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                xmlSerializerNewSerializer.endDocument();
            } catch (IllegalStateException e) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);
            } catch (IOException e2) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e2);
            } catch (IllegalArgumentException e3) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e3);
            } finally {
                this.this$0.mCanReadHistoricalData = true;
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused) {
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e4) {
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + str, e4);
            return null;
        }
    }
}
