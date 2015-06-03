/*
 * Hivemall: Hive scalable Machine Learning Library
 *
 * Copyright (C) 2015 Makoto YUI
 * Copyright (C) 2013-2015 National Institute of Advanced Industrial Science and Technology (AIST)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hivemall.knn.distance;

import hivemall.knn.similarity.AngularSimilarityUDF;

import java.util.List;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;
import org.apache.hadoop.io.FloatWritable;

/**
 * @see http://en.wikipedia.org/wiki/Cosine_similarity#Angular_similarity
 */
@Description(name = "angular_distance", value = "_FUNC_(ftvec1, ftvec2) - Returns an angular distance of the given two vectors")
@UDFType(deterministic = true, stateful = false)
public final class AngularDistanceUDF extends UDF {

    public FloatWritable evaluate(List<String> ftvec1, List<String> ftvec2) {
        float d = 1.f - AngularSimilarityUDF.angularSimilarity(ftvec1, ftvec2);
        return new FloatWritable(d);
    }
}
