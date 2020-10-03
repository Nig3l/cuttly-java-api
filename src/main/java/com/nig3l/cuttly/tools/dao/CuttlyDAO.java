package com.nig3l.cuttly.tools.dao;

import com.nig3l.cuttly.models.CuttlyObject;
import com.nig3l.cuttly.tools.exception.CuttlyException;
import org.json.simple.JSONObject;

public interface CuttlyDAO<E> {

    E jsonToObject(JSONObject json) throws CuttlyException;

    JSONObject objectToJson(E object);

    void handleErrors(int status) throws CuttlyException;
}
