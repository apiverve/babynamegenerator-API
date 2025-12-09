using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.BabyNameGenerator
{
    /// <summary>
    /// Query options for the Baby Name Generator API
    /// </summary>
    public class BabyNameGeneratorQueryOptions
    {
        /// <summary>
        /// The gender you would like the generated names to be based off (e.g. male, female)
        /// Example: male
        /// </summary>
        [JsonProperty("gender")]
        public string Gender { get; set; }

        /// <summary>
        /// The number of names to generate
        /// Example: 1
        /// </summary>
        [JsonProperty("count")]
        public string Count { get; set; }
    }
}
