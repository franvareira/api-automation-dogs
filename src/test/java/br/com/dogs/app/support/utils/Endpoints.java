package br.com.dogs.app.support.utils;

public class Endpoints {

    protected static final String BASE_URI = FileOperations.getProperties("environments").getProperty("baseUri");
    protected static final String BASE_URI_PARAM = FileOperations.getProperties("environments").getProperty("baseUriParam");
    protected static final String PATH_ALL = FileOperations.getProperties("environments").getProperty("pathAll");
    protected static final String PATH_RANDOM = FileOperations.getProperties("environments").getProperty("pathRandom");
    protected static final String PATH_PARAM = FileOperations.getProperties("environments").getProperty("pathParam");

}
