package ws.vinta.albedo

import org.apache.spark.ml.feature.SQLTransformer

package object preprocessors {
  private val popularReposSQL = """
  SELECT repo_id, stargazers_count
  FROM __THIS__
  WHERE stargazers_count > 1000
  ORDER BY stargazers_count DESC
  """
  val popularReposBuilder = new SQLTransformer()
  popularReposBuilder.setStatement(popularReposSQL)
}