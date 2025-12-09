declare module '@apiverve/babynamegenerator' {
  export interface babynamegeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface babynamegeneratorResponse {
    status: string;
    error: string | null;
    data: BabyNameGeneratorData;
    code?: number;
  }


  interface BabyNameGeneratorData {
      count: number;
      names: Name[];
  }
  
  interface Name {
      firstName:  string;
      middleName: string;
      fullName:   string;
  }

  export default class babynamegeneratorWrapper {
    constructor(options: babynamegeneratorOptions);

    execute(callback: (error: any, data: babynamegeneratorResponse | null) => void): Promise<babynamegeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: babynamegeneratorResponse | null) => void): Promise<babynamegeneratorResponse>;
    execute(query?: Record<string, any>): Promise<babynamegeneratorResponse>;
  }
}
