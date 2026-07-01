package com.adjust.sdk;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UtilNetworking {
    private static String userAgent;

    public static class ConnectionOptions implements IConnectionOptions {
        @Override // com.adjust.sdk.UtilNetworking.IConnectionOptions
        public void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str) {
            httpsURLConnection.setRequestProperty("Client-SDK", str);
            httpsURLConnection.setConnectTimeout(60000);
            httpsURLConnection.setReadTimeout(60000);
            if (UtilNetworking.userAgent != null) {
                httpsURLConnection.setRequestProperty("User-Agent", UtilNetworking.userAgent);
            }
        }
    }

    public interface IConnectionOptions {
        void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str);
    }

    private static String buildAuthorizationHeader(Map<String, String> map, String str) {
        String strExtractSecretId = extractSecretId(map);
        String strBuildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(map), strExtractSecretId, extractHeadersId(map), extractAlgorithm(map), extractNativeVersion(map));
        return strBuildAuthorizationHeaderV2 != null ? strBuildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(map, extractAppSecret(map), strExtractSecretId, str);
    }

    private static String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String string = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", Util.sha256(signature.get("clear_signature"))), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        getLogger().verbose("authorizationHeader: %s", string);
        return string;
    }

    private static String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String string = Util.formatString("signature=\"%s\"", str);
        String string2 = Util.formatString("secret_id=\"%s\"", str2);
        String string3 = Util.formatString("headers_id=\"%s\"", str3);
        Object[] objArr = new Object[1];
        if (str4 == null) {
            str4 = "adj1";
        }
        objArr[0] = str4;
        String string4 = Util.formatString("algorithm=\"%s\"", objArr);
        Object[] objArr2 = new Object[1];
        if (str5 == null) {
            str5 = "";
        }
        objArr2[0] = str5;
        String string5 = Util.formatString("Signature %s,%s,%s,%s,%s", string, string2, string4, string3, Util.formatString("native_version=\"%s\"", objArr2));
        getLogger().verbose("authorizationHeader: %s", string5);
        return string5;
    }

    private static Uri buildUri(String str, Map<String, String> map, String str2) {
        String path;
        Uri.Builder builder = new Uri.Builder();
        String protocol = Constants.SCHEME;
        String authority = Constants.AUTHORITY;
        try {
            String baseUrl = AdjustFactory.getBaseUrl();
            if (str2 != null) {
                baseUrl = baseUrl + str2;
            }
            URL url = new URL(baseUrl);
            protocol = url.getProtocol();
            authority = url.getAuthority();
            path = url.getPath();
        } catch (MalformedURLException e) {
            getLogger().error("Unable to parse endpoint (%s)", e.getMessage());
            path = "";
        }
        builder.scheme(protocol);
        builder.encodedAuthority(authority);
        builder.path(path);
        builder.appendPath(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        builder.appendQueryParameter("sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        return builder.build();
    }

    public static ResponseData createGETHttpsURLConnection(ActivityPackage activityPackage, String str) throws Exception {
        try {
            HashMap map = new HashMap(activityPackage.getParameters());
            extractEventCallbackId(map);
            HttpsURLConnection httpsURLConnection = AdjustFactory.getHttpsURLConnection(new URL(buildUri(activityPackage.getPath(), map, str).toString()));
            AdjustFactory.getConnectionOptions().applyConnectionOptions(httpsURLConnection, activityPackage.getClientSdk());
            String strBuildAuthorizationHeader = buildAuthorizationHeader(map, activityPackage.getActivityKind().toString());
            if (strBuildAuthorizationHeader != null) {
                httpsURLConnection.setRequestProperty("Authorization", strBuildAuthorizationHeader);
            }
            httpsURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            return readHttpResponse(httpsURLConnection, activityPackage);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResponseData createPOSTHttpsURLConnection(String str, ActivityPackage activityPackage, int i) throws Exception {
        DataOutputStream dataOutputStream = null;
        try {
            try {
                HttpsURLConnection httpsURLConnection = AdjustFactory.getHttpsURLConnection(new URL(str));
                HashMap map = new HashMap(activityPackage.getParameters());
                AdjustFactory.getConnectionOptions().applyConnectionOptions(httpsURLConnection, activityPackage.getClientSdk());
                extractEventCallbackId(map);
                String strBuildAuthorizationHeader = buildAuthorizationHeader(map, activityPackage.getActivityKind().toString());
                if (strBuildAuthorizationHeader != null) {
                    httpsURLConnection.setRequestProperty("Authorization", strBuildAuthorizationHeader);
                }
                httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpsURLConnection.getOutputStream());
                try {
                    dataOutputStream2.writeBytes(getPostDataString(map, i));
                    ResponseData httpResponse = readHttpResponse(httpsURLConnection, activityPackage);
                    try {
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    return httpResponse;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    private static String getPostDataString(Map<String, String> map, int i) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String strEncode = URLEncoder.encode(next.getKey(), Constants.ENCODING);
            String value = next.getValue();
            String strEncode2 = value != null ? URLEncoder.encode(value, Constants.ENCODING) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strEncode);
            sb.append("=");
            sb.append(strEncode2);
        }
        String str = Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis()));
        sb.append("&");
        sb.append(URLEncoder.encode("sent_at", Constants.ENCODING));
        sb.append("=");
        sb.append(URLEncoder.encode(str, Constants.ENCODING));
        if (i > 0) {
            sb.append("&");
            sb.append(URLEncoder.encode("queue_size", Constants.ENCODING));
            sb.append("=");
            sb.append(URLEncoder.encode("" + i, Constants.ENCODING));
        }
        return sb.toString();
    }

    private static Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String str3 = map.get("created_at");
        String validIdentifier = getValidIdentifier(map);
        String str4 = map.get(validIdentifier);
        String str5 = map.get("source");
        String str6 = map.get("payload");
        HashMap map2 = new HashMap();
        map2.put("app_secret", str2);
        map2.put("created_at", str3);
        map2.put("activity_kind", str);
        map2.put(validIdentifier, str4);
        if (str5 != null) {
            map2.put("source", str5);
        }
        if (str6 != null) {
            map2.put("payload", str6);
        }
        String strJ = "";
        String string = "";
        for (Map.Entry entry : map2.entrySet()) {
            if (entry.getValue() != null) {
                strJ = outline.J(outline.U(strJ), (String) entry.getKey(), " ");
                StringBuilder sbU = outline.U(string);
                sbU.append((String) entry.getValue());
                string = sbU.toString();
            }
        }
        String strSubstring = strJ.substring(0, strJ.length() - 1);
        HashMap map3 = new HashMap();
        map3.put("clear_signature", string);
        map3.put("fields", strSubstring);
        return map3;
    }

    private static String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get("android_id") != null) {
            return "android_id";
        }
        if (map.get("mac_sha1") != null) {
            return "mac_sha1";
        }
        if (map.get("mac_md5") != null) {
            return "mac_md5";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    private static ResponseData readHttpResponse(HttpsURLConnection httpsURLConnection, ActivityPackage activityPackage) throws Exception {
        JSONObject jSONObject;
        StringBuffer stringBuffer = new StringBuffer();
        ILogger logger = getLogger();
        ResponseData responseDataBuildResponseData = ResponseData.buildResponseData(activityPackage);
        try {
            try {
                httpsURLConnection.connect();
                Integer numValueOf = Integer.valueOf(httpsURLConnection.getResponseCode());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(numValueOf.intValue() >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream()));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                }
                httpsURLConnection.disconnect();
                String string = stringBuffer.toString();
                logger.verbose("Response: %s", string);
                if (numValueOf.intValue() == 429) {
                    logger.error("Too frequent requests to the endpoint (429)", new Object[0]);
                    return responseDataBuildResponseData;
                }
                if (string != null && string.length() != 0) {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e) {
                        String string2 = Util.formatString("Failed to parse json response. (%s)", e.getMessage());
                        logger.error(string2, new Object[0]);
                        responseDataBuildResponseData.message = string2;
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        return responseDataBuildResponseData;
                    }
                    responseDataBuildResponseData.jsonResponse = jSONObject;
                    String strOptString = jSONObject.optString("message", null);
                    responseDataBuildResponseData.message = strOptString;
                    responseDataBuildResponseData.timestamp = jSONObject.optString("timestamp", null);
                    responseDataBuildResponseData.adid = jSONObject.optString("adid", null);
                    String strOptString2 = jSONObject.optString("tracking_state", null);
                    if (strOptString2 != null && strOptString2.equals("opted_out")) {
                        responseDataBuildResponseData.trackingState = TrackingState.OPTED_OUT;
                    }
                    if (strOptString == null) {
                        strOptString = "No message found";
                    }
                    if (numValueOf.intValue() == 200) {
                        logger.info("%s", strOptString);
                        responseDataBuildResponseData.success = true;
                    } else {
                        logger.error("%s", strOptString);
                    }
                }
                return responseDataBuildResponseData;
            } catch (Exception e2) {
                logger.error("Failed to read response. (%s)", e2.getMessage());
                throw e2;
            }
        } catch (Throwable th) {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }
}
